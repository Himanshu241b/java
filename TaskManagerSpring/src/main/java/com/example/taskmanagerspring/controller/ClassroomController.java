package com.example.taskmanagerspring.controller;

import com.example.taskmanagerspring.dto.*;
import com.example.taskmanagerspring.entity.ClassroomEntity;
import com.example.taskmanagerspring.entity.UserEntity;
import com.example.taskmanagerspring.service.ClassroomService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/classroom")
@CrossOrigin(origins = "http://localhost:3000")

public class ClassroomController {

    private final ModelMapper modelMapper;
    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService, ModelMapper modelMapper){
        this.classroomService = classroomService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/createdClassrooms")
    public ResponseEntity<List<ClassroomResponseDTO>> getCreatedClassrooms(@AuthenticationPrincipal UserEntity user){
        var createdClassesOfUser = classroomService.getCreatedClassrooms(user);
        List<ClassroomResponseDTO>  userCreatedClasses = createdClassesOfUser.stream()
                .map(classroom -> {
                    ClassroomResponseDTO ClassroomResponseDTO = modelMapper.map(classroom, ClassroomResponseDTO.class);
                    return ClassroomResponseDTO;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(userCreatedClasses);
    }

    @GetMapping("/joinedClassrooms")
    public ResponseEntity<List<ClassroomResponseDTO>> getJoinedClassrooms(@AuthenticationPrincipal UserEntity user){
        var joinedClassroomsList = classroomService.getJoinedClassrooms(user);
        List<ClassroomResponseDTO> joinedClassrooms = joinedClassroomsList.stream()
                .map(classroom -> {
                    ClassroomResponseDTO classroomResponseDTO = modelMapper.map(classroom, ClassroomResponseDTO.class);
                    return classroomResponseDTO;
                }).collect(Collectors.toList());

        return ResponseEntity.ok(joinedClassrooms);
    }

    @PostMapping("")
    public ResponseEntity<CreateClassroomResponseDTO> addClassroom(@RequestBody CreateClassroomDTO createClassroomDTO, @AuthenticationPrincipal UserEntity user){
        ClassroomEntity newClassroom = classroomService.addClassroom(createClassroomDTO, user);
        CreateClassroomResponseDTO createClassroomResponseDTO = new CreateClassroomResponseDTO();
        createClassroomResponseDTO.setClassroomName(newClassroom.getClassroomName());
        createClassroomResponseDTO.setCreatorName(newClassroom.getCreatorUserEntity().getUsername());
        return ResponseEntity.ok(createClassroomResponseDTO);
    }

    @PutMapping("/joinClassroom/{classroomId}")
    public ResponseEntity<String> joinClassroom(@AuthenticationPrincipal UserEntity user, @PathVariable Long classroomId) throws ClassroomService.ClassNotFoundException, ClassroomService.ClassAlreadyJoinedException {
        String joinResponse = classroomService.joinClassroom(user, classroomId);

        return ResponseEntity.ok(joinResponse);
    }


    @PutMapping("/{classroomId}")
    public ResponseEntity<UpdatedClassroomResponseDTO> updateClassroom(@AuthenticationPrincipal UserEntity user, @PathVariable Long classroomId, @RequestBody UpdateClassroomDTO updateClassroomDTO)throws ClassroomService.ClassNotFoundException , IllegalAccessException{
        ClassroomEntity updatedClassroom = classroomService.updateClassroom(user, classroomId, updateClassroomDTO.getClassroomName());
        UpdatedClassroomResponseDTO updatedClassroomResponseDTO = modelMapper.map(updatedClassroom, UpdatedClassroomResponseDTO.class);
        return ResponseEntity.ok(updatedClassroomResponseDTO);
    }

    @DeleteMapping("/{classroomId}")
    public ResponseEntity<String> deleteClassroom(@AuthenticationPrincipal UserEntity user, @PathVariable Long classroomId)throws ClassroomService.ClassNotFoundException, IllegalAccessException{
        classroomService.deleteClassroom(user, classroomId);
        return ResponseEntity.ok("Classroom deleted successfully");
    }

    @PostMapping("/leaveClassroom/{classroomId}")
    public ResponseEntity<String> leaveClass(@AuthenticationPrincipal UserEntity user, @PathVariable("classroomId") Long classId){
        String leaveResponse = classroomService.leaveClassroom(user, classId);
        return ResponseEntity.ok(leaveResponse);
    }



    @ExceptionHandler({
            ClassroomService.ClassNotFoundException.class,
            IllegalAccessException.class,
            ClassroomService.ClassAlreadyJoinedException.class
    })
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception exception){
        String message;
        HttpStatus status;
        if(exception instanceof ClassroomService.ClassNotFoundException){
            message = exception.getMessage();
            status = HttpStatus.NOT_FOUND;
        }
        else if(exception instanceof IllegalAccessException){
            message = exception.getMessage();
            status = HttpStatus.BAD_REQUEST;
        }
        else if(exception instanceof ClassroomService.ClassAlreadyJoinedException){
            message = exception.getMessage();
            status = HttpStatus.BAD_REQUEST;
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
