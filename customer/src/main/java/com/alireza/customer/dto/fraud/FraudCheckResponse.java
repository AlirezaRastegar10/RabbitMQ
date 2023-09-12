package com.alireza.customer.dto.fraud;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FraudCheckResponse {

    Boolean isFraudster;
}
