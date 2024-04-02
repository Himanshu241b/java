package com.example.taskmanagerspring.service;

import com.example.taskmanagerspring.entity.TaskEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private List<TaskEntity> taskList = new ArrayList<TaskEntity>();
    private int taskId = 1;
    private final SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public TaskEntity addTask(String title, String description, String deadline) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(deadlineFormatter.parse(deadline));
        task.setCompleted(false);
        taskList.add(task);
        ++taskId;
        return task;
    }

    public List<TaskEntity> getTasks(){
        return taskList;
    }

    public TaskEntity getTaskById(int id){
        for(TaskEntity task : taskList){
            if(task.getId() == id){
                return task;
            }
        }
        return null;
    }



    public TaskEntity updateTask(int id, String description, String deadline, Boolean completed) throws ParseException{
        TaskEntity task = getTaskById(id);
        if(task == null)
            return null;

        if(description != null)
            task.setDescription(description);
        if(deadline != null)
            task.setDeadline(deadlineFormatter.parse(deadline));
        if(completed != null)
            task.setCompleted(completed);
        return task;
    }
}

