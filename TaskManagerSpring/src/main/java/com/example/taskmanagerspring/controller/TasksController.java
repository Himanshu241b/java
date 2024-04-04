package com.example.taskmanagerspring.controller;

import com.example.taskmanagerspring.dto.*;
import com.example.taskmanagerspring.entity.TaskEntity;
import com.example.taskmanagerspring.entity.UserEntity;
import com.example.taskmanagerspring.service.NoteService;
import com.example.taskmanagerspring.service.TaskService;
import com.example.taskmanagerspring.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users/{userIdEncoded}/tasks")
public class TasksController {

    private final ModelMapper modelMapper = new ModelMapper();

    private final TaskService taskService;
    private final UserService userService;


    TasksController(TaskService taskService, NoteService noteService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }
    @GetMapping("")
    public ResponseEntity<List<UserTasksDTO>> getTasksOfUser(@PathVariable("userIdEncoded") String userIdEncoded) throws EntityNotFoundException{
        // Decode the Base64-encoded string
        byte[] decodedBytes = Base64.getDecoder().decode(userIdEncoded);
        String decodedUserIdString = new String(decodedBytes);

        // Parse the decoded string to a Long
        Long userIdDecoded = Long.parseLong(decodedUserIdString);


        var userTasks = taskService.getTasks(userIdDecoded);

        List<UserTasksDTO> userTasksList = userTasks.stream()
                .map(task -> {
                    UserTasksDTO userTasksDTO = modelMapper.map(task, UserTasksDTO.class);
                    return userTasksDTO;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(userTasksList);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponseDTO> getTaskByIdForUser(@PathVariable("taskId") Long taskId, @PathVariable("userIdEncoded") String userIdEncoded) throws EntityNotFoundException, UnsupportedEncodingException{

        // Decode the Base64-encoded string
        byte[] decodedBytes = Base64.getDecoder().decode(userIdEncoded);
        String decodedUserIdString = new String(decodedBytes);

        // Parse the decoded string to a Long
        Long userIdDecoded = Long.parseLong(decodedUserIdString);

        TaskEntity userTaskById = taskService.getTaskByIdForUser(taskId, userIdDecoded);

        TaskResponseDTO taskResponseDTO = modelMapper.map(userTaskById, TaskResponseDTO.class);

        return ResponseEntity.ok(taskResponseDTO);
    }

    @PostMapping("")
    public ResponseEntity<CreateTaskResponseDTO> addTask(@RequestBody CreateTaskDTO createTaskDTO, @PathVariable("userIdEncoded") String userIdEncoded) throws ParseException, UnsupportedEncodingException{
        // Decode the Base64-encoded string
        byte[] decodedBytes = Base64.getDecoder().decode(userIdEncoded);
        String decodedUserIdString = new String(decodedBytes);

        // Parse the decoded string to a Long
        Long userIdDecoded = Long.parseLong(decodedUserIdString);

        UserEntity user = userService.getUserById(userIdDecoded);

        TaskEntity newTask = taskService.addTask(createTaskDTO, user);

        CreateTaskResponseDTO createTaskResponseDTO = modelMapper.map(newTask, CreateTaskResponseDTO.class);

        return ResponseEntity.ok(createTaskResponseDTO);
    }

    @PatchMapping("/{taskId}")
    public ResponseEntity<UpdateTaskResponseDTO> updateTask(@PathVariable("taskId") Long taskId, @PathVariable("userIdEncoded") String userIdEncoded, @RequestBody UpdateTaskDTO updateTaskDTO) throws EntityNotFoundException, ParseException, UnsupportedEncodingException{

        // Decode the Base64-encoded string
        byte[] decodedBytes = Base64.getDecoder().decode(userIdEncoded);
        String decodedUserIdString = new String(decodedBytes);

        // Parse the decoded string to a Long
        Long userIdDecoded = Long.parseLong(decodedUserIdString);

        TaskEntity updatedTask = taskService.updateTask(taskId, userIdDecoded, updateTaskDTO);
        UpdateTaskResponseDTO updatedTaskResponseDTO = modelMapper.map(updatedTask, UpdateTaskResponseDTO.class);
        return ResponseEntity.ok(updatedTaskResponseDTO);
    }

    @ExceptionHandler(
            {ParseException.class
            , EntityNotFoundException.class
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

