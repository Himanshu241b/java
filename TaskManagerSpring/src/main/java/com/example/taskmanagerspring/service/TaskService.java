package com.example.taskmanagerspring.service;

import com.example.taskmanagerspring.entity.TaskEntity;
import com.example.taskmanagerspring.repository.TasksRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service
public class TaskService {

    private final TasksRepository tasksRepository;

    public TaskService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }
    private List<TaskEntity> taskList = new ArrayList<TaskEntity>();
    private int taskId = 1;
    private final SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public TaskEntity addTask(String title, String description, String deadline) throws ParseException{
        TaskEntity newTask = new TaskEntity();
        newTask.setTitle(title);
        newTask.setDescription(description);
        newTask.setDeadline(deadlineFormatter.parse(deadline));
        newTask.setCompleted(false);

        return tasksRepository.save(newTask);
    }

    public List<TaskEntity> getTasks(){
        return tasksRepository.findAll();
    }

    public TaskEntity getTaskById(Long id) throws EntityNotFoundException{
        var task = tasksRepository.getById(id);
        if(task == null){
            throw new EntityNotFoundException("Task with id " + id + "not found");
        }
        return task;
    }



    public TaskEntity updateTask(Long id, String description, String deadline, Boolean completed) throws EntityNotFoundException, ParseException {
            TaskEntity task = tasksRepository.getById(id);
            if(task == null){
                throw new EntityNotFoundException("Task with id " + id + " not found");
            }
            if (description != null)
                task.setDescription(description);
            if (deadline != null)
                task.setDeadline(deadlineFormatter.parse(deadline));
            if (completed != null)
                task.setCompleted(completed);

            return tasksRepository.save(task);

    }


}

