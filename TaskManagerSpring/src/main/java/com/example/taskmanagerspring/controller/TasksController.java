package com.example.taskmanagerspring.controller;

import com.example.taskmanagerspring.dto.CreateTaskDTO;
import com.example.taskmanagerspring.dto.ErrorResponseDTO;
import com.example.taskmanagerspring.dto.TaskResponseDTO;
import com.example.taskmanagerspring.dto.UpdateTaskDTO;
import com.example.taskmanagerspring.entity.TaskEntity;
import com.example.taskmanagerspring.service.NoteService;
import com.example.taskmanagerspring.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private ModelMapper modelMapper = new ModelMapper();

    private final NoteService noteService;
    private final TaskService taskService;

    @Autowired
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
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable("id") Integer id){
        var task = taskService.getTaskById(id);
        var notes = noteService.getNotesForTask(id);
        if(task == null){
            return ResponseEntity.notFound().build();
        }
        var taskResponse = modelMapper.map(task, TaskResponseDTO.class);
        taskResponse.setNotes(notes);
        return ResponseEntity.ok(taskResponse);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO createTaskDTO) throws ParseException{
        TaskEntity newTask = taskService.addTask(createTaskDTO.getTitle(), createTaskDTO.getDescription(), createTaskDTO.getDeadline());

        return ResponseEntity.ok(newTask);
    }

    @ExceptionHandler(ParseException.class)
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception exception){
        if(exception instanceof ParseException){
            return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid date format."));
        }

        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal Server error."));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO updateTaskDTO) throws ParseException{
        var task = taskService.updateTask(id, updateTaskDTO.getDescription(), updateTaskDTO.getDeadline(), updateTaskDTO.getCompleted());
        if(task == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }
}
