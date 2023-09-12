package com.alireza.fraud.service;


import com.alireza.fraud.dto.fraud.FraudCheckResponse;
import com.alireza.fraud.entity.FraudCheckHistory;
import com.alireza.fraud.mappers.FraudMapperImpl;
import com.alireza.fraud.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudCheckServiceImpl implements FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    private final FraudMapperImpl fraudMapper;

    @Override
    public FraudCheckResponse isFraudulentCustomer(Long customerId) {
        var fraud = fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .build()
        );
        return fraudMapper.fraudToFraudDto(fraud);
    }
}
