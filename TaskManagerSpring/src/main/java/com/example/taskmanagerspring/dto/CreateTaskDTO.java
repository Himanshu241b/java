package com.example.taskmanagerspring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateTaskDTO { // DTO => data transfer object
    private String title;
    private String description;
    private String deadline;
}
