package com.example.taskmanagerspring.service;

import com.example.taskmanagerspring.dto.CreateTaskDTO;
import com.example.taskmanagerspring.dto.UpdateTaskDTO;
import com.example.taskmanagerspring.entity.TaskEntity;
import com.example.taskmanagerspring.entity.UserEntity;
import com.example.taskmanagerspring.repository.TasksRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.List;


@Service
public class TaskService {

    private final TasksRepository tasksRepository;

    public TaskService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    private final SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public TaskEntity addTask(CreateTaskDTO createTaskDTO, UserEntity user) throws ParseException{
        TaskEntity newTask = new TaskEntity();
        newTask.setTitle(createTaskDTO.getTitle());
        newTask.setDescription(createTaskDTO.getDescription());
        newTask.setDeadline(deadlineFormatter.parse(createTaskDTO.getDeadline()));
        newTask.setUserEntity(user);
        newTask.setCompleted(false);

        return tasksRepository.save(newTask);
    }

    public List<TaskEntity> getTasks(Long userId){
        List<TaskEntity> userTasksList = tasksRepository.findAllByUserId(userId);
        return userTasksList;
    }


    public TaskEntity getTaskByIdForUser(Long taskId, Long userId) throws EntityNotFoundException{

        TaskEntity userTaskById = tasksRepository.findTaskByIdForUser(taskId, userId);
        if(userTaskById == null)
        {
            throw new EntityNotFoundException("Task with id " + taskId + " not found");
        }
        else{
            return userTaskById;
        }
    }

    public TaskEntity updateTask(Long taskId, Long userId, UpdateTaskDTO updateTaskDTO) throws EntityNotFoundException, ParseException {
            TaskEntity task = tasksRepository.findTaskByIdForUser(taskId, userId);
            if(task == null){
                throw new EntityNotFoundException("Task with id " + taskId + " not found");
            }
            if (updateTaskDTO.getDescription() != null)
                task.setDescription(updateTaskDTO.getDescription());
            if (updateTaskDTO.getDeadline() != null)
                task.setDeadline(deadlineFormatter.parse(updateTaskDTO.getDeadline()));
            if (updateTaskDTO.getCompleted() != null)
                task.setCompleted(updateTaskDTO.getCompleted());

            return tasksRepository.save(task);
    }
}

