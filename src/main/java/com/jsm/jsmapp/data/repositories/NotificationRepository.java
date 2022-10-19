package com.jsm.jsmapp.data.repositories;

import com.jsm.jsmapp.data.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
