package com.alireza.notification.dto.notification;


public record NotificationRequest(
        Long toCustomerId,
        String toCustomerEmail,
        String message){
}
