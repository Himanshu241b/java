package com.example.taskmanagerspring.service;

import com.example.taskmanagerspring.entity.NoteEntity;
import com.example.taskmanagerspring.repository.NotesRepository;
import com.example.taskmanagerspring.repository.TasksRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
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

    class TaskNotesHolder {
        protected int noteId = 1;
        protected List<NoteEntity> notes = new ArrayList<NoteEntity>();
    }


    public List<NoteEntity> getNotesForTask(Long taskId) throws EntityNotFoundException {
        var task = tasksRepository.getById(taskId);
        if(task == null){
            throw new EntityNotFoundException("Task with id " + taskId + " not found.");
        }
        else{
            List<NoteEntity> notesList = notesRepository.findAllBytaskId();
            if(notesList.size() == 0){
                throw new NotesListEmptyException(taskId);
            }
            return notesList;
        }
    }

    //    public NoteEntity addNoteForTask(Long taskId, String title, String body){
//
//    }

    public static class NotesListEmptyException extends RuntimeException{
        public NotesListEmptyException(Long taskId){
            super("No notes are present, for task with "+ taskId);
        }
    }
}





