package com.example.taskmanagerspring.controller;

import com.example.taskmanagerspring.dto.CreateTaskDTO;
import com.example.taskmanagerspring.dto.ErrorResponseDTO;
import com.example.taskmanagerspring.dto.TaskResponseDTO;
import com.example.taskmanagerspring.dto.UpdateTaskDTO;
import com.example.taskmanagerspring.entity.TaskEntity;
import com.example.taskmanagerspring.service.NoteService;
import com.example.taskmanagerspring.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final ModelMapper modelMapper = new ModelMapper();

    private final NoteService noteService;
    private final TaskService taskService;


    TasksController(TaskService taskService, NoteService noteService) {
        this.taskService = taskService;
        this.noteService = noteService;
    }
    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){
        var tasks = taskService.getTasks();

        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable("id") Long id) throws EntityNotFoundException{
        var task = taskService.getTaskById(id);
        var notes = noteService.getNotesForTask(id);

        var taskResponse = modelMapper.map(task, TaskResponseDTO.class);
        taskResponse.setNotes(notes);
        return ResponseEntity.ok(taskResponse);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO createTaskDTO) throws ParseException{
        TaskEntity newTask = taskService.addTask(createTaskDTO.getTitle(), createTaskDTO.getDescription(), createTaskDTO.getDeadline());

        return ResponseEntity.ok(newTask);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable("id") Long id, @RequestBody UpdateTaskDTO updateTaskDTO) throws EntityNotFoundException, ParseException{
        var task = taskService.updateTask(id, updateTaskDTO.getDescription(), updateTaskDTO.getDeadline(), updateTaskDTO.getCompleted());
        return ResponseEntity.ok(task);
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

