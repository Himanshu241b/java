package com.example.taskmanagerspring.repository;

import com.example.taskmanagerspring.entity.TaskSubmissionEntity;
import com.example.taskmanagerspring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskSubmissionRepository extends JpaRepository<TaskSubmissionEntity, Long> {


    @Query("SELECT t FROM TaskSubmissionEntity t " +
            "WHERE t.user = :user AND t.classroom.classId = :classId")
    List<TaskSubmissionEntity> findAllTasksOfUserInClassroom(UserEntity user, Long classId);
}
