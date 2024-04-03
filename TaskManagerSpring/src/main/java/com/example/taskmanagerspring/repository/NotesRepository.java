package com.example.taskmanagerspring.repository;

import com.example.taskmanagerspring.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotesRepository extends JpaRepository<NoteEntity, Long> {
    @Query("SELECT n FROM NoteEntity n WHERE n.taskEntity.id = :taskId")
    List<NoteEntity> findAllByTaskId(Long taskId);}
