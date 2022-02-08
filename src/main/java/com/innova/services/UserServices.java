package com.innova.services;

import com.innova.dto.UserDto;
import com.innova.entity.UserEntity;
import com.innova.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserServices {

    @Autowired
    UserRepository userRepository;

    // http://localhost:8090/service/postCreateUserService
    @PostMapping("/service/postCreateUserService")
    public boolean postCreateUserService(@RequestBody UserDto dto)
    {

            UserEntity entity = UserEntity.builder()
                    .userId(0L)
                    .userName(dto.getUserName())
                    .userSurname(dto.getUserSurname())
                    .emailAddress(dto.getEmailAddress())
                    .userAge(dto.getUserAge())
                    .userMessage(dto.getUserMessage())
                    .build();
            userRepository.save(entity);

            return true;
    }

    // http://localhost:8090/service/getUserService/1
    @GetMapping("/service/getUserService/{id}")
    public UserDto getUserService(@PathVariable(name="id") Long myId){

        Optional<UserEntity> optional = userRepository.findById(myId);
        UserDto dto = null;
        if(optional.isPresent()){
            var entity = optional.get();
            dto = new UserDto().builder()
                    .userId(entity.getUserId())
                    .userName(entity.getUserName())
                    .userSurname(entity.getUserSurname())
                    .userAge(entity.getUserAge())
                    .emailAddress(entity.getEmailAddress())
                    .userMessage(entity.getUserMessage())
                    .build();
        }

        return dto;
    }

    // http://localhost:8090/service/postUpdateUserService
    @PostMapping("/service/postUpdateUserService")
    public boolean postUpdateUserService(@RequestBody UserDto dto){

        Optional<UserEntity> optional = userRepository.findById(dto.getUserId());
        if(optional.isPresent()){
            var entity = optional.get();
            entity.setUserName(dto.getUserName());
            entity.setUserSurname(dto.getUserSurname());
            entity.setUserAge(dto.getUserAge());
            entity.setEmailAddress(dto.getEmailAddress());
            entity.setUserMessage(dto.getUserMessage());
            userRepository.save(entity);
            return true;
        }
        return false;

    }

    // http://localhost:8090/service/deleteUserService/1
    @GetMapping("/service/deleteUserService/{id}")
    public boolean deleteUserService(@PathVariable(name = "id") Long myId){

        Optional<UserEntity> optional = userRepository.findById(myId);
        if(optional.isPresent()){
            var entity = optional.get();
            userRepository.delete(entity);
            return true;
        }
        return false;
    }

}
