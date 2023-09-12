package com.alireza.customer.service;


import com.alireza.amqp.producer.RabbitMQMessageProducer;
import com.alireza.customer.client.FraudClient;
import com.alireza.customer.dto.customer.CustomerRequest;
import com.alireza.customer.dto.customer.CustomerResponse;
import com.alireza.customer.dto.notification.NotificationRequest;
import com.alireza.customer.mappers.CustomerMapperImpl;
import com.alireza.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapperImpl customerMapper;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    @Override
    public CustomerResponse saveCustomer(CustomerRequest customerRequest) {
        var customer = customerMapper.customerDtoToCustomer(customerRequest);
        var newCustomer = customerRepository.save(customer);
        var isFraudster = fraudClient.isFraudster(newCustomer.getId());
        if (isFraudster.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to my microservice...", customer.getEmail())
        );
        rabbitMQMessageProducer.publish(notificationRequest, "internal.exchange", "internal.notification.routing-key");
        return customerMapper.customerToCustomerDto(newCustomer);
    }
}
