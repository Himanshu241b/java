package com.example.taskmanagerspring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "notes")
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String title;

    private String body;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;
}
