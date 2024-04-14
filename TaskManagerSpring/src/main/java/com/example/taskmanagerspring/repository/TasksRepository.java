package com.example.taskmanagerspring.repository;

import com.example.taskmanagerspring.entity.TaskEntity;
import com.example.taskmanagerspring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TasksRepository extends JpaRepository<TaskEntity, Long> {


}

