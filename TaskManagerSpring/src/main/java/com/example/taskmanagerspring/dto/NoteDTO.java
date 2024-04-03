package com.example.taskmanagerspring.dto;

import lombok.Data;

@Data
public class NoteDTO {
    private Long id;
    private String title;
    private String body;
}
