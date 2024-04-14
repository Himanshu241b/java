package com.example.taskmanagerspring.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "classrooms")

public class ClassroomEntity {
    @Column(nullable = false)
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    @Column(nullable = false)
    @NonNull
    private String classroomName;

    @NonNull
    @ManyToOne
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JoinColumn(nullable = false, name = "creatorId", referencedColumnName ="userId")
    private UserEntity creatorUserEntity;


    @OneToMany(mappedBy = "classroom")
    private List<TaskSubmissionEntity> taskSubmissions;



    // One-to-many mapping to represent multiple tasks associated with a classroom
    @OneToMany(mappedBy = "classroomEntity")
    private List<TaskEntity> assignedTasks;


    @ManyToMany() // if we write cascade = CascadeType.ALL means all operations including removal should be cascaded to associated entities
    @JoinTable(name = "users_classrooms",
            joinColumns = @JoinColumn(name = "classId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<UserEntity> joinedUsers;
}
