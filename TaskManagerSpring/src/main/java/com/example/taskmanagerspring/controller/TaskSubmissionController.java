package com.example.taskmanagerspring.controller;

import com.example.taskmanagerspring.dto.SubmitTaskResponseDTO;
import com.example.taskmanagerspring.dto.SubmittedTaskDTO;
import com.example.taskmanagerspring.entity.TaskSubmissionEntity;
import com.example.taskmanagerspring.entity.UserEntity;
import com.example.taskmanagerspring.service.TaskSubmissionEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/submit")
@CrossOrigin(origins = "http://localhost:3000")

public class TaskSubmissionController {

    private final ModelMapper modelMapper;
    private final TaskSubmissionEntityService taskSubmissionEntityService;

    public TaskSubmissionController(ModelMapper modelMapper, TaskSubmissionEntityService taskSubmissionEntityService) {
        this.taskSubmissionEntityService = taskSubmissionEntityService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<SubmitTaskResponseDTO> submitTask(@AuthenticationPrincipal UserEntity user, @RequestParam("classId") Long classId, @RequestParam("taskId") Long taskId){
        TaskSubmissionEntity taskSubmissionEntity = taskSubmissionEntityService.submitTask(user, classId, taskId);
        SubmitTaskResponseDTO submitTaskResponseDTO = SubmitTaskResponseDTO.builder()
                    .submissionId(taskSubmissionEntity.getSubmissionId())
                    .title(taskSubmissionEntity.getTask().getTitle())
                    .description(taskSubmissionEntity.getTask().getDescription())
                    .deadline(taskSubmissionEntity.getTask().getDeadline())
                    .submissionStatus(taskSubmissionEntity.getSubmissionStatus())
                    .build();
        return ResponseEntity.ok(submitTaskResponseDTO);
    }
    @GetMapping("/submitted")
    public ResponseEntity<List<SubmittedTaskDTO>> getSubmittedTasksOfUserInClassroom(@AuthenticationPrincipal UserEntity user, @RequestParam("classId") Long classId){
        List<TaskSubmissionEntity> submittedTasksList = taskSubmissionEntityService.getSubmittedTasksOfUserInClassroom(user, classId);
        List<SubmittedTaskDTO> submittedTaskDTOs = submittedTasksList.stream()
                .map(submittedTask->{
                    SubmittedTaskDTO submittedTaskDTO = SubmittedTaskDTO.builder()
                            .submissionId(submittedTask.getSubmissionId())
                            .taskTitle(submittedTask.getTask().getTitle())
                            .taskDescription(submittedTask.getTask().getDescription())
                            .taskDeadline(submittedTask.getTask().getDeadline())
                            .status(submittedTask.getSubmissionStatus())
                            .build();
                    return submittedTaskDTO;
                }).collect(Collectors.toList());

        return ResponseEntity.ok(submittedTaskDTOs);
    }

    


}
