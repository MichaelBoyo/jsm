package com.jsm.jsmapp.services.notificationService;

import com.jsm.jsmapp.data.models.Notification;
import com.jsm.jsmapp.data.repositories.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService{
    private final NotificationRepository notificationRepository;

    @Override
    public Notification addNotification(String message) {
        return notificationRepository.save(Notification.builder()
                        .message(message)
                        .date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")))
                .build());
    }


    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }


}
