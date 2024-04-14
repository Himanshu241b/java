package com.example.taskmanagerspring.dto;

import com.example.taskmanagerspring.entity.SubmissionStatus;
import com.example.taskmanagerspring.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubmittedTaskDTO {
    private Long submissionId;
    private String taskTitle;
    private String taskDescription;
    private Date taskDeadline;
    private SubmissionStatus status;
}
