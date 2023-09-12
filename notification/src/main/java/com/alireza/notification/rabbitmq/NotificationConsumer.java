package com.alireza.notification.rabbitmq;


import com.alireza.notification.dto.notification.NotificationRequest;
import com.alireza.notification.service.NotificationServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class NotificationConsumer {

    private final NotificationServiceImpl notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(@Payload NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
