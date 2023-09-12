package com.alireza.customer.dto.exception;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseException {

    Timestamp timestamp;
    Integer status;
    String error;
    String message;
    String path;
}
