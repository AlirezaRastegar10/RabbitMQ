package com.alireza.fraud.service;

import com.alireza.fraud.dto.fraud.FraudCheckResponse;

public interface FraudCheckService {

    FraudCheckResponse isFraudulentCustomer(Long customerId);
}
