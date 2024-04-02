package com.example.taskmanagerspring.controller;

import com.example.taskmanagerspring.dto.CreateNoteDTO;
import com.example.taskmanagerspring.dto.CreateNoteResponseDTO;
import com.example.taskmanagerspring.entity.NoteEntity;
import com.example.taskmanagerspring.service.NoteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {
    private final NoteService noteService;

    NotesController(NoteService noteService) {
        this.noteService = noteService;
    }
    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Long taskId) {
        var notes = noteService.getNotesForTask(taskId);
        return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<CreateNoteResponseDTO> addNote(
            @PathVariable("taskId") Long taskId,
            @RequestBody CreateNoteDTO createNoteDTO
    ){
        var note = noteService.addNoteForTask(taskId, createNoteDTO.getTitle(), createNoteDTO.getBody());

        return ResponseEntity.ok(new CreateNoteResponseDTO(taskId, note));
    }
}
