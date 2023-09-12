package com.alireza.customer.controller;


import com.alireza.customer.dto.customer.CustomerRequest;
import com.alireza.customer.dto.customer.CustomerResponse;
import com.alireza.customer.service.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @PostMapping("/save")
    public ResponseEntity<CustomerResponse> save(@RequestBody @Valid CustomerRequest customerRequest) {
        log.info("new customer registration {}", customerRequest);
        return ResponseEntity.ok(customerService.saveCustomer(customerRequest));
    }
}
