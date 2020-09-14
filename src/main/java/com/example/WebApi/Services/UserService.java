package com.example.WebApi.Services;

import com.example.WebApi.Entity.User;
import com.example.WebApi.Repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserRepository userRepository;

    public ResponseEntity login(User user) {
        if(userRepository.findOne(Example.of(user)).isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body("You successfully logged in!");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your Username or Password is wrong!");
        }
    }

    public ResponseEntity signUp(User newUser) {
        if(userRepository.findByEmail(newUser.getEmail()) == null){
            userRepository.save(newUser);
            return ResponseEntity.status(HttpStatus.OK).body("Signed Up!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This Email already exists.");
        }
    }

    public List<User> getUser() {
        List<User> userList = userRepository.findAll();
        return userList;
    }
}
