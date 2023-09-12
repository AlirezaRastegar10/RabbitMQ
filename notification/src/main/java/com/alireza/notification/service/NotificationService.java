package com.alireza.notification.service;

import com.alireza.notification.dto.notification.NotificationRequest;

public interface NotificationService {

    void send(NotificationRequest notificationRequest);
}
