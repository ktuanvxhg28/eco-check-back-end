package com.ktuan28.eco_check.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NotificationID")
    private Long notificationId;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(name = "Message", nullable = false)
    private String message;

    @Column(name = "SentDate", nullable = false)
    private LocalDateTime sentDate;

    @Column(name = "IsRead", nullable = false)
    private Boolean isRead = false;

}
