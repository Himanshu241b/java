package com.example.blogspring.comments;

import com.example.blogspring.articles.ArticleEntity;
import com.example.blogspring.users.UserEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity(name = "comments")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@AllArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Nullable
    private String title;

    @NonNull
    private String body;

    @CreatedDate
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "articleId", nullable = false)
    private ArticleEntity articleEntity;

    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false)
    private UserEntity userEntity;
}
