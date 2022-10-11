package com.jsm.jsmapp.data.repositories;

import com.jsm.jsmapp.data.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
