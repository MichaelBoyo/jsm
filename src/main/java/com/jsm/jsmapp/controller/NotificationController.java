package com.jsm.jsmapp.controller;

import com.jsm.jsmapp.data.models.Notification;
import com.jsm.jsmapp.services.notificationService.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    @GetMapping("/all")
    public List<Notification> getAllNotifications(){
        return notificationService.findAll();
    }
}
