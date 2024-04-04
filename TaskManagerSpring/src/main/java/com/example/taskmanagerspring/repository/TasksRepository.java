package com.example.taskmanagerspring.repository;

import com.example.taskmanagerspring.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TasksRepository extends JpaRepository<TaskEntity, Long> {
    TaskEntity getById(Long taskId);

    @Query("SELECT t FROM TaskEntity t WHERE t.userEntity.userId = :userId")
    List<TaskEntity> findAllByUserId(Long userId);

    // Method to fetch tasks by task ID for a particular user
    @Query("SELECT t FROM TaskEntity t WHERE t.taskId = :taskId AND t.userEntity.userId = :userId")
    TaskEntity findTaskByIdForUser(@Param("taskId") Long taskId, @Param("userId") Long userId);

}

