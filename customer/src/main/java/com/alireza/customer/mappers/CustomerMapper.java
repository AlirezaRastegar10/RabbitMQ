package com.alireza.customer.mappers;


import com.alireza.customer.dto.customer.CustomerRequest;
import com.alireza.customer.dto.customer.CustomerResponse;
import com.alireza.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    Customer customerDtoToCustomer(CustomerRequest customerRequest);

    CustomerResponse customerToCustomerDto(Customer customer);
}
