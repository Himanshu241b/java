package com.example.taskmanagerspring.service;

import com.example.taskmanagerspring.dto.CreateNoteDTO;
import com.example.taskmanagerspring.entity.NoteEntity;
import com.example.taskmanagerspring.repository.NotesRepository;
import com.example.taskmanagerspring.repository.TasksRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import java.util.List;

@Service
public class NoteService {
    private final TasksRepository tasksRepository;
    private final NotesRepository notesRepository;
    @Autowired
    NoteService(TasksRepository tasksRepository, NotesRepository notesRepository) {
        this.tasksRepository = tasksRepository;
        this.notesRepository = notesRepository;
    }


    public List<NoteEntity> getNotesForTask(Long taskId) throws EntityNotFoundException, NotesListEmptyException {
        var task = tasksRepository.getById(taskId);
        if(task == null){
            throw new EntityNotFoundException("Task with id " + taskId + " not found.");
        }
        else{
            List<NoteEntity> notesList = notesRepository.findAllByTaskId(taskId);
            if(notesList.size() == 0){
                throw new NotesListEmptyException(taskId);
            }
            return notesList;
        }
    }

        public NoteEntity addNoteForTask(Long taskId, CreateNoteDTO createNoteDTO) throws EntityNotFoundException{
            var task = tasksRepository.getById(taskId);
            if(task == null){
                throw new EntityNotFoundException("Task with id " + taskId + " not found.");
            }
            NoteEntity newNote = new NoteEntity();
            newNote.setTitle(createNoteDTO.getTitle());
            newNote.setBody(createNoteDTO.getBody());
            newNote.setTaskEntity(task);
            return notesRepository.save(newNote);
        }

    public static class NotesListEmptyException extends RuntimeException{
        public NotesListEmptyException(Long taskId){
            super("No notes are present, for task with id:"+ taskId);
        }
    }
}





