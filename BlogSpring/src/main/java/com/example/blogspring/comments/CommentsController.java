package com.example.blogspring.comments;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles/{article-slug}/comments")
public class CommentsController {
}
