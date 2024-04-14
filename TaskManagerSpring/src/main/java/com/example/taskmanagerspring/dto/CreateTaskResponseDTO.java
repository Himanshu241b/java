package com.example.taskmanagerspring.dto;

import lombok.Data;

@Data
public class CreateTaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String deadline;
}
