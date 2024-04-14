package com.example.blogspring.articles.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class UpdateArticleRequest {
    @Nullable
    private String title;

    @Nullable
    private String body;

    @Nullable
    private String subtitle;

}
