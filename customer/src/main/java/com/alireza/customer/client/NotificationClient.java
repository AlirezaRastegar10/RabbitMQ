package com.alireza.customer.client;


import com.alireza.customer.dto.notification.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification", url = "${application.config.notification-url}")
public interface NotificationClient {

    @PostMapping("/send-notification")
    void sendNotification(NotificationRequest notificationRequest);
}
