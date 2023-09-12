package com.alireza.fraud.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class FraudCheckHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long customerId;
    Boolean isFraudster;

    @CreationTimestamp
    LocalDateTime createdAt;
}
