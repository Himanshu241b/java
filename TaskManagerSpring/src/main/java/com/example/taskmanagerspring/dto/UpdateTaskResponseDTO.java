package com.example.taskmanagerspring.dto;

import lombok.Data;

@Data
public class UpdateTaskResponseDTO {
    private int id;
    private String title;
    private String description;
    private String deadline;
    private Boolean completed;
}
