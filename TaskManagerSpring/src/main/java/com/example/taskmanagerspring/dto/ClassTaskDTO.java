package com.example.taskmanagerspring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ClassTaskDTO {
    private Long taskId;

    private String title;

    private String description;

    private Date deadline;

}
