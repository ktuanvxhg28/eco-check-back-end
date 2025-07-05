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
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LogID")
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(name = "Action", nullable = false)
    private String action;

    @Column(name = "Timestamp", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "EntityType")
    private String entityType;

    @Column(name = "EntityID")
    private String entityId;
}
