package com.example.taskmanagerspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "task_submissions")
public class TaskSubmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long submissionId;

    @ManyToOne
    @JoinColumn(name = "taskId", referencedColumnName = "taskId")
    private TaskEntity task;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "classroomId", referencedColumnName = "classId")
    private ClassroomEntity classroom;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubmissionStatus submissionStatus;

}

