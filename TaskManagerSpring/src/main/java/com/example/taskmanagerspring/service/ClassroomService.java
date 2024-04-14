package com.example.taskmanagerspring.service;

import com.example.taskmanagerspring.dto.CreateClassroomDTO;
import com.example.taskmanagerspring.entity.ClassroomEntity;
import com.example.taskmanagerspring.entity.UserEntity;
import com.example.taskmanagerspring.repository.ClassroomRepository;
import com.example.taskmanagerspring.repository.UsersRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ClassroomService {

    private final UsersRepository usersRepository;
    private final UserService userService;

    private final ClassroomRepository classroomRepository;

    public ClassroomService(UsersRepository usersRepository, ClassroomRepository classroomRepository, UserService userService) {
        this.classroomRepository = classroomRepository;
        this.userService = userService;
        this.usersRepository = usersRepository;
    }

    public ClassroomEntity getClassroomById(Long classId)throws EntityNotFoundException {
        ClassroomEntity classroom = classroomRepository.findById(classId).orElseThrow(()->new EntityNotFoundException("Cannot found classroom with id " + classId));
        return classroom;
    }

    public String joinClassroom(UserEntity user, Long classroomId)throws EntityNotFoundException, ClassAlreadyJoinedException{
        ClassroomEntity classroomToJoin = classroomRepository.findById(classroomId).orElseThrow(()->new ClassNotFoundException((classroomId)));
        UserEntity userEntity = userService.getUserById(user.getUserId());
        if(classroomToJoin.getJoinedUsers().contains(userEntity)){
            throw new ClassAlreadyJoinedException(userEntity.getUsername());
        }
        classroomToJoin.getJoinedUsers().add(userEntity);
        userEntity.getJoinedClassrooms().add(classroomToJoin);
        classroomRepository.save(classroomToJoin);
        return "Classroom joined successfully";
    }
    public List<ClassroomEntity> getCreatedClassrooms(UserEntity user) {
        List<ClassroomEntity> createdClassrooms = classroomRepository.getCreatedClassesByUser(user);
        return createdClassrooms;
    }

    public List<ClassroomEntity> getJoinedClassrooms(UserEntity user) {
        UserEntity userEntity = userService.getUserById(user.getUserId());
        List<ClassroomEntity> joinedClassrooms = userEntity.getJoinedClassrooms();
        return joinedClassrooms;
    }

    public ClassroomEntity addClassroom(CreateClassroomDTO createClassroomDTO, UserEntity user){
        ClassroomEntity newClassroom = new ClassroomEntity();
        newClassroom.setClassroomName(createClassroomDTO.getClassroomName());
        newClassroom.setCreatorUserEntity(user);
        return classroomRepository.save(newClassroom);
    }

    public ClassroomEntity updateClassroom(UserEntity user, Long classroomId, String updateClassroomName)throws ClassNotFoundException, IllegalAccessException{

        ClassroomEntity classroom = classroomRepository.getById(classroomId);
        if(classroom == null){
            throw new ClassNotFoundException(classroomId);
        }
        if(classroom.getCreatorUserEntity().getUserId() != user.getUserId()){
            throw new IllegalAccessException("Not allowed to update this classroom");
        }
        classroom.setClassroomName(updateClassroomName);
        return (ClassroomEntity) classroomRepository.save(classroom);
    }

    public void deleteClassroom(UserEntity user, Long classroomId)throws ClassNotFoundException, IllegalAccessException{

        ClassroomEntity classToDelete = classroomRepository.getById(classroomId);
        UserEntity userEntity = userService.getUserById(user.getUserId());
        if(classToDelete == null){
            throw new ClassNotFoundException(classroomId);
        }
        if(classToDelete.getCreatorUserEntity().getUserId() != userEntity.getUserId()){
            throw new IllegalAccessException("Not allowed to delete this class");
        }
        // Remove the classroom from joinedClassrooms list of each associated user
        for (UserEntity joinedUser : classToDelete.getJoinedUsers()) {
            joinedUser.getJoinedClassrooms().remove(classToDelete);
        }
        classroomRepository.delete(classToDelete);

    }

    public String leaveClassroom(UserEntity user, Long classId)throws ClassNotFoundException{
        ClassroomEntity classroomToLeave = classroomRepository.findById(classId).orElseThrow(() ->new ClassNotFoundException(classId));
        UserEntity userToLeave = userService.getUserById(user.getUserId());
        classroomToLeave.getJoinedUsers().remove(userToLeave);
        return userToLeave.getUsername() +" left the classroom.";
    }


    public static class ClassNotFoundException extends EntityNotFoundException {
        public ClassNotFoundException(Long classId){
            super("Class with id " + classId + " not found");
        }
    }

    public static class ClassAlreadyJoinedException extends RuntimeException {
        public ClassAlreadyJoinedException(String userName) {
            super(userName + " already in class");
        }
    }
}
