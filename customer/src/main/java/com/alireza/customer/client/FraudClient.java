package com.alireza.customer.client;


import com.alireza.customer.dto.fraud.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "fraud-service", url = "${application.config.fraud-url}")
public interface FraudClient {

    @PostMapping("/is-fraudster/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable Long customerId);
}
