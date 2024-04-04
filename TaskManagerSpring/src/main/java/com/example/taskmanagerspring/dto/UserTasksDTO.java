package com.example.taskmanagerspring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserTasksDTO {
    private Long id;

    private String title;

    private String description;

    private Date deadline;

    private Boolean completed;
}
