package com.example.taskmanagerspring.controller;

import com.example.taskmanagerspring.dto.*;
import com.example.taskmanagerspring.entity.TaskEntity;
import com.example.taskmanagerspring.entity.UserEntity;
import com.example.taskmanagerspring.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:3000")

public class TasksController {

    private final ModelMapper modelMapper = new ModelMapper();

    private final TaskService taskService;


    TasksController(TaskService taskService) {
        this.taskService = taskService;

    }
    @GetMapping("/{classroomId}")
    public ResponseEntity<List<ClassTaskDTO>> getTasksOfClass(@PathVariable("classroomId") Long classId) throws EntityNotFoundException{

        var classTasks = taskService.getTasksOfClassroom(classId);

        List<ClassTaskDTO> classTasksList = classTasks.stream()
                .map(task -> {
                    ClassTaskDTO classTaskDTO = modelMapper.map(task, ClassTaskDTO.class);
                    return classTaskDTO;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(classTasksList);
    }

//    @GetMapping("/{taskId}")
//    public ResponseEntity<TaskResponseDTO> getTaskByIdForUser(@PathVariable("taskId") Long taskId, @AuthenticationPrincipal UserEntity user) throws EntityNotFoundException{
//
//        System.out.println(user.getUsername());
//        TaskEntity userTaskById = taskService.getTaskByIdForUser(user, taskId);
//
//        TaskResponseDTO taskResponseDTO = modelMapper.map(userTaskById, TaskResponseDTO.class);
//
//        return ResponseEntity.ok(taskResponseDTO);
//    }

    @PostMapping("/{classroomId}")
    public ResponseEntity<CreateTaskResponseDTO> addTaskToClassroom(@RequestBody CreateTaskDTO createTaskDTO, @AuthenticationPrincipal UserEntity user, @PathVariable("classroomId") Long classId) throws ParseException, IllegalAccessException{

        TaskEntity newTask = taskService.addTaskToClassroom(createTaskDTO, user, classId);

        CreateTaskResponseDTO createTaskResponseDTO = modelMapper.map(newTask, CreateTaskResponseDTO.class);

        return ResponseEntity.ok(createTaskResponseDTO);
    }

//    @PatchMapping("/{taskId}")
//    public ResponseEntity<UpdateTaskResponseDTO> updateTask(@PathVariable("taskId") Long taskId, @PathVariable("userIdEncoded") String userIdEncoded, @RequestBody UpdateTaskDTO updateTaskDTO) throws EntityNotFoundException, ParseException, UnsupportedEncodingException{
//
//        // Decode the Base64-encoded string
//        byte[] decodedBytes = Base64.getDecoder().decode(userIdEncoded);
//        String decodedUserIdString = new String(decodedBytes);
//
//        // Parse the decoded string to a Long
//        Long userIdDecoded = Long.parseLong(decodedUserIdString);
//
//        TaskEntity updatedTask = taskService.updateTask(taskId, userIdDecoded, updateTaskDTO);
//        UpdateTaskResponseDTO updatedTaskResponseDTO = modelMapper.map(updatedTask, UpdateTaskResponseDTO.class);
//        return ResponseEntity.ok(updatedTaskResponseDTO);
//    }

    @ExceptionHandler(
            {ParseException.class
            , EntityNotFoundException.class
            , IllegalAccessException.class
            }
    )
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception exception){
            String message;
            HttpStatus status;
            if(exception instanceof EntityNotFoundException){
                message = exception.getMessage();
                status = HttpStatus.NOT_FOUND;
            }
            else if(exception instanceof ParseException) {
                message = exception.getMessage();
                status = HttpStatus.BAD_REQUEST;
            }
            else if(exception instanceof IllegalAccessException){
                message = exception.getMessage();
                status = HttpStatus.BAD_REQUEST;
            }
            else{
                message = "something went wrong";
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            ErrorResponseDTO errorResponse = ErrorResponseDTO.builder()
                    .message(message)
                    .build();
            return ResponseEntity.status(status).body(errorResponse);
        }
    }

