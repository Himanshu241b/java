package com.example.taskmanagerspring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
public class TaskResponseDTO {
    private int taskId;
    private String title;
    private String description;
    private Date deadline;
    private boolean completed;

}
