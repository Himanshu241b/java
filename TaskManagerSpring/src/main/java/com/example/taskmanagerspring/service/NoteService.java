package com.example.taskmanagerspring.service;

import com.example.taskmanagerspring.entity.NoteEntity;
import com.example.taskmanagerspring.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NoteService {
    private TaskService taskService;
    private HashMap<Integer, TaskNotesHolder> taskNotesHolderMap = new HashMap<Integer, TaskNotesHolder>();
    @Autowired
    NoteService(TaskService taskService) {
        this.taskService = taskService;
    }

    class TaskNotesHolder{
        protected int noteId = 1;
        protected List<NoteEntity> notes = new ArrayList<NoteEntity>();
    }

    public List<NoteEntity> getNotesForTask(int taskId){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(taskNotesHolderMap.get(taskId) == null)
            taskNotesHolderMap.put(taskId, new TaskNotesHolder());
        return taskNotesHolderMap.get(taskId).notes;
    }

    public NoteEntity addNoteForTask(int taskId, String title, String body){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null)
            return null;
        if(taskNotesHolderMap.get(taskId) == null)
            taskNotesHolderMap.put(taskId, new TaskNotesHolder());
        TaskNotesHolder taskNotesHolder = taskNotesHolderMap.get(taskId);
        NoteEntity note = new NoteEntity();
        note.setId(taskNotesHolder.noteId);
        note.setTitle(title);
        note.setBody(body);
        taskNotesHolder.notes.add(note);
        taskNotesHolder.noteId++;
        return note;
    }
}
