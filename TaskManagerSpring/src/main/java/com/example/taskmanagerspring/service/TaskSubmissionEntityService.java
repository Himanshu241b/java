package com.example.taskmanagerspring.service;

import com.example.taskmanagerspring.entity.*;
import com.example.taskmanagerspring.repository.TaskSubmissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TaskSubmissionEntityService {

    private final ClassroomService classroomService;
    private final TaskService taskService;
    private final UserService userService;
    private final TaskSubmissionRepository taskSubmissionRepository;

    public TaskSubmissionEntityService(UserService userService, TaskSubmissionRepository taskSubmissionRepository, ClassroomService classroomService, TaskService taskService) {
        this.classroomService = classroomService;
        this.taskService = taskService;
        this.userService = userService;
        this.taskSubmissionRepository = taskSubmissionRepository;
    }

    public TaskSubmissionEntity submitTask(UserEntity user, Long classId, Long taskId){
        ClassroomEntity classroomOfTaskToSubmit = classroomService.getClassroomById(classId);
        TaskEntity taskToSubmit = taskService.getTaskById(taskId);
        UserEntity userToSubmit = userService.getUserById(user.getUserId());

        TaskSubmissionEntity taskSubmissionEntity = new TaskSubmissionEntity();
        taskSubmissionEntity.setTask(taskToSubmit);
        taskSubmissionEntity.setUser(userToSubmit);
        taskSubmissionEntity.setClassroom(classroomOfTaskToSubmit);
        if(taskToSubmit.getDeadline().toInstant().isAfter(Instant.now())) {
            taskSubmissionEntity.setSubmissionStatus(SubmissionStatus.ON_TIME_SUBMISSION);
        }
        else{
            taskSubmissionEntity.setSubmissionStatus(SubmissionStatus.LATE_SUBMISSION);
        }
        return taskSubmissionRepository.save(taskSubmissionEntity);
    }

    public List<TaskSubmissionEntity> getSubmittedTasksOfUserInClassroom(UserEntity user, Long classId){
        List submittedTasksList = taskSubmissionRepository.findAllTasksOfUserInClassroom(user, classId);
        return submittedTasksList;
    }
}
