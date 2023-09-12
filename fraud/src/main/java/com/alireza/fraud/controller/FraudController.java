package com.alireza.fraud.controller;


import com.alireza.fraud.dto.fraud.FraudCheckResponse;
import com.alireza.fraud.service.FraudCheckServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud")
@RequiredArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckServiceImpl fraudCheckService;

    @PostMapping("/is-fraudster/{customerId}")
    public ResponseEntity<FraudCheckResponse> isFraudster(@PathVariable Long customerId) {
        log.info("fraud check request for customer {}", customerId);
        return ResponseEntity.ok(fraudCheckService.isFraudulentCustomer(customerId));
    }
}
