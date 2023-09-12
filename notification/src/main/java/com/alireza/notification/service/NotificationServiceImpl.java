package com.alireza.notification.service;


import com.alireza.notification.dto.notification.NotificationRequest;
import com.alireza.notification.entity.Notification;
import com.alireza.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .sender("alireza")
                        .message(notificationRequest.message())
                        .build()
        );
    }
}
