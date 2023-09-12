package com.alireza.customer.dto.notification;


public record NotificationRequest(
        Long toCustomerId,
        String toCustomerEmail,
        String message
) {
}
