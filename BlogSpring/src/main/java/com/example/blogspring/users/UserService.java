package com.example.blogspring.users;

import com.example.blogspring.users.dtos.CreateUserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UserService(UsersRepository usersRepository, ModelMapper modelMapper){
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    public UserEntity createUser(CreateUserRequest createUserRequest){
        UserEntity newUser = modelMapper.map(createUserRequest, UserEntity.class);
       //TODO: encrypt and save password
        return usersRepository.save(newUser);
    }

    public UserEntity getUser(String username){
        return usersRepository.findByUsername(username).orElseThrow(()-> new UserService.UserNotFoundException(username));
    }

    public UserEntity getUser(Long id){
        return usersRepository.findById(id).orElseThrow(()->new UserService.UserNotFoundException(id));
    }


    public UserEntity loginUser(String username, String password){
        var user = usersRepository.findByUsername(username).orElseThrow(()-> new UserService.UserNotFoundException(username));

        //TODO: match password
        return user;
    }

    public static class UserNotFoundException extends IllegalArgumentException{
        public UserNotFoundException(String username){
            super("User with name"+ username+ " not found");
        }
        public UserNotFoundException(Long userId){
            super("User with id"+ userId+ " not found");

        }
    }
}
