package com.example.taskmanagerspring.dto;

import com.example.taskmanagerspring.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateNoteResponseDTO {
    private Long taskId;
    private NoteEntity note;
}
