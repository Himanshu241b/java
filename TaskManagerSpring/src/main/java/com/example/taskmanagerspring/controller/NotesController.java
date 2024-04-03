package com.example.taskmanagerspring.controller;

import com.example.taskmanagerspring.dto.CreateNoteDTO;
import com.example.taskmanagerspring.dto.CreateNoteResponseDTO;
import com.example.taskmanagerspring.dto.ErrorResponseDTO;
import com.example.taskmanagerspring.dto.NoteDTO;
import com.example.taskmanagerspring.entity.NoteEntity;
import com.example.taskmanagerspring.service.NoteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {
    private final NoteService noteService;

    NotesController(NoteService noteService) {
        this.noteService = noteService;
    }
    @GetMapping("")
    public ResponseEntity<List<NoteDTO>> getNotes(@PathVariable("taskId") Long taskId) throws NoteService.NotesListEmptyException, EntityNotFoundException{
        var notes = noteService.getNotesForTask(taskId);
        // Map NoteEntity to NoteDTO
        List<NoteDTO> noteDTOs = notes.stream()
                .map(note -> {
                    NoteDTO noteDTO = new NoteDTO();
                    noteDTO.setId(note.getId());
                    noteDTO.setTitle(note.getTitle());
                    noteDTO.setBody(note.getBody());
                    return noteDTO;
                })
                .collect(Collectors.toList());


        return ResponseEntity.ok(noteDTOs);
    }

    @PostMapping("")
    public ResponseEntity<CreateNoteResponseDTO> addNote(
            @PathVariable("taskId") Long taskId,
            @RequestBody CreateNoteDTO createNoteDTO
    ) throws EntityNotFoundException{
        NoteEntity newNote = noteService.addNoteForTask(taskId, createNoteDTO);
        CreateNoteResponseDTO createNoteResponseDTO = new CreateNoteResponseDTO();
        createNoteResponseDTO.setId(newNote.getId());
        createNoteResponseDTO.setBody(newNote.getBody());
        createNoteResponseDTO.setTitle(newNote.getTitle());
        return ResponseEntity.ok(createNoteResponseDTO);

    }

    @ExceptionHandler({
            NoteService.NotesListEmptyException.class,
            EntityNotFoundException.class
    })
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception exception){
        String message;
        HttpStatus status;
        if(exception instanceof EntityNotFoundException){
            message = exception.getMessage();
            status = HttpStatus.NOT_FOUND;
        }
        else if(exception instanceof NoteService.NotesListEmptyException) {
            message = exception.getMessage();
            status = HttpStatus.NOT_FOUND;
        }
        else{
            message = "something went wrong";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        ErrorResponseDTO errorResponse = ErrorResponseDTO.builder()
                .message(message)
                .build();
        return ResponseEntity.status(status).body(errorResponse);
    }
}
