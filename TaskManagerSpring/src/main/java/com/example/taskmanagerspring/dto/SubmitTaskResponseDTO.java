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
public class SubmitTaskResponseDTO {
    private Long submissionId;

    private String title;

    private String description;

    private Date deadline;

    private SubmissionStatus submissionStatus;
}
