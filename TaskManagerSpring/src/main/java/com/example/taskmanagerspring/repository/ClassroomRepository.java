package com.example.taskmanagerspring.repository;


import com.example.taskmanagerspring.entity.ClassroomEntity;
import com.example.taskmanagerspring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<ClassroomEntity, Long> {

    @Query("select c from ClassroomEntity c where c.creatorUserEntity = :user")
    List<ClassroomEntity> getCreatedClassesByUser(UserEntity user);


}
