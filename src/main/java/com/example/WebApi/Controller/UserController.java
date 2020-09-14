package com.example.WebApi.Controller;

import com.example.WebApi.Entity.User;
import com.example.WebApi.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping()
public class UserController {
    @Resource
    UserService userService;

//    @Operation(summary = "checks login", description = "No Authentication and Autorisation yet", tags = { "UserManagement" })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User user){
       return userService.login(user);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity signUp(@RequestBody User newUser){
        return userService.signUp(newUser);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getUser();
    }

}
