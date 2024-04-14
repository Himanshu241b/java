package com.example.taskmanagerspring.service;

import com.example.taskmanagerspring.dto.CreateTaskDTO;
import com.example.taskmanagerspring.entity.ClassroomEntity;
import com.example.taskmanagerspring.entity.TaskEntity;
import com.example.taskmanagerspring.entity.UserEntity;
import com.example.taskmanagerspring.repository.ClassroomRepository;
import com.example.taskmanagerspring.repository.TasksRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Transactional
@Service
public class TaskService {

    private final TasksRepository tasksRepository;
    private final ClassroomService classroomService;
    private final UserService userService;
    private final ClassroomRepository classroomRepository;

    public TaskService(ClassroomRepository classroomRepository, TasksRepository tasksRepository, UserService userService , ClassroomService classroomService) {
        this.tasksRepository = tasksRepository;
        this.classroomService = classroomService;
        this.userService = userService;
        this.classroomRepository = classroomRepository;

    }

    private final SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public TaskEntity addTaskToClassroom(CreateTaskDTO createTaskDTO, UserEntity user, Long classId) throws IllegalAccessException, ParseException{
          UserEntity userEntity = userService.getUserById(user.getUserId());
          ClassroomEntity classroomEntity = classroomService.getClassroomById(classId);
          if(classroomEntity.getCreatorUserEntity().getUserId() != userEntity.getUserId()){
              throw new IllegalAccessException(userEntity.getUsername() + " is not allowed to add any tasks.");
          }
          else{
                TaskEntity newTask = new TaskEntity();
                newTask.setTitle(createTaskDTO.getTitle());
                newTask.setDescription(createTaskDTO.getDescription());
                newTask.setDeadline(deadlineFormatter.parse(createTaskDTO.getDeadline()));
                newTask.setClassroomEntity(classroomEntity);
                classroomEntity.getAssignedTasks().add(newTask);
                tasksRepository.save(newTask);
                classroomRepository.save(classroomEntity);
                return newTask;
          }
    }

    public TaskEntity getTaskById(Long taskId){
        TaskEntity foundTask =  tasksRepository.findById(taskId).orElse(null);
        return foundTask;
    }

    public List<TaskEntity> getTasksOfClassroom(Long classId){
        ClassroomEntity classroom = classroomService.getClassroomById(classId);
        List<TaskEntity> tasksOfUser = classroom.getAssignedTasks();
        return tasksOfUser;
    }



//    public TaskEntity getTaskByIdForUser(UserEntity user, Long taskId) throws EntityNotFoundException{
//
//        TaskEntity userTaskById = tasksRepository.findTaskByIdForUser(user, taskId);
//        if(userTaskById == null)
//        {
//            throw new EntityNotFoundException("Task with id " + taskId + " not found");
//        }
//        else{
//            return userTaskById;
//        }
//    }

//    public TaskEntity updateTask(Long taskId, Long userId, UpdateTaskDTO updateTaskDTO) throws EntityNotFoundException, ParseException {
//            TaskEntity task = tasksRepository.findTaskByIdForUser(taskId, userId);
//            if(task == null){
//                throw new EntityNotFoundException("Task with id " + taskId + " not found");
//            }
//            if (updateTaskDTO.getDescription() != null)
//                task.setDescription(updateTaskDTO.getDescription());
//            if (updateTaskDTO.getDeadline() != null)
//                task.setDeadline(deadlineFormatter.parse(updateTaskDTO.getDeadline()));
//            if (updateTaskDTO.getCompleted() != null)
//                task.setCompleted(updateTaskDTO.getCompleted());
//
//            return tasksRepository.save(task);
//    }
}

