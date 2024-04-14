package com.example.taskmanagerspring.dto;

import com.example.taskmanagerspring.entity.ClassroomEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CreateTaskDTO { // DTO => data transfer object
    private String title;
    private String description;
    private String deadline;
    private Long classid;

}
