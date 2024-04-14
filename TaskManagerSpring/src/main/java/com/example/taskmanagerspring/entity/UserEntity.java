package com.example.taskmanagerspring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    @NonNull
    private String username;

    @Column(nullable = false)
    @NonNull
    private String email;

    @Column(nullable = false)
    @NonNull
    private String password;

    @OneToMany(mappedBy = "user")
    private List<TaskSubmissionEntity> submissions;

    @ManyToMany(mappedBy = "joinedUsers")
    private List<ClassroomEntity> joinedClassrooms;
}
