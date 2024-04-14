package com.example.taskmanagerspring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateClassroomResponseDTO {
    private String classroomName;
    private String creatorName;

}
