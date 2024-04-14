package com.example.taskmanagerspring.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long taskId;

    private String title;

    private String description;

    private Date deadline;


    @OneToMany(mappedBy = "task")
    private List<TaskSubmissionEntity> submissions;

    @ManyToOne
    @JoinColumn(name = "classroomId", referencedColumnName = "classId")
    private ClassroomEntity classroomEntity;



}
