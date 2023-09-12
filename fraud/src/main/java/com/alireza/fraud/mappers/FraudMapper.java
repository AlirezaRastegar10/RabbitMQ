package com.alireza.fraud.mappers;


import com.alireza.fraud.dto.fraud.FraudCheckResponse;
import com.alireza.fraud.entity.FraudCheckHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FraudMapper {

    FraudCheckResponse fraudToFraudDto(FraudCheckHistory fraudCheckHistory);
}
