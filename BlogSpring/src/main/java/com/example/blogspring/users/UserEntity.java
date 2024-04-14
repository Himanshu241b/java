package com.example.blogspring.users;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;

@Entity(name = "users")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    @NonNull
    private String username;
    @Column(nullable = false)
    @NonNull
    private String email;
    @Column(nullable = true)
    private String bio;
    @Column(nullable = true)
    private String image;

}
