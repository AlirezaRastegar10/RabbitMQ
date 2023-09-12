package com.alireza.customer.service;

import com.alireza.customer.dto.customer.CustomerRequest;
import com.alireza.customer.dto.customer.CustomerResponse;

public interface CustomerService {

    CustomerResponse saveCustomer(CustomerRequest customerRequest);
}
