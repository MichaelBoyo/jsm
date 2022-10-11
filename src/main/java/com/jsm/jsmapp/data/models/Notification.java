package com.jsm.jsmapp.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Notification {
    @Id
    private String id;
    @NonNull
    private String message;
    @NonNull
    private String date;
}
