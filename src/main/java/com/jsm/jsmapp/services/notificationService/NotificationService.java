package com.jsm.jsmapp.services.notificationService;

import com.jsm.jsmapp.data.models.Notification;

import java.util.List;

public interface NotificationService {
    Notification addNotification(String message);

    List<Notification> findAll();
}
