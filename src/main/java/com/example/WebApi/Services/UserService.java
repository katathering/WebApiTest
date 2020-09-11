package com.example.WebApi.Services;

import com.example.WebApi.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserRepository userRepository;
}
