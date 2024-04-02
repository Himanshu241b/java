package com.example.taskmanagerspring.repository;

import com.example.taskmanagerspring.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<TaskEntity, Long> {
    TaskEntity getById(long id);
}
