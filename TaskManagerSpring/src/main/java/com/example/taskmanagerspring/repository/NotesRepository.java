package com.example.taskmanagerspring.repository;

import com.example.taskmanagerspring.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<NoteEntity, Long> {

}
