package com.example.seas.security.controller;

import com.example.seas.common.MessageResponse;
import com.example.seas.security.dto.UserDTO;
import com.example.seas.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add/{userType}")
    @PreAuthorize("permitAll()")
    public MessageResponse addUser(@PathVariable String userType, @RequestBody UserDTO userDTO){
        System.out.println(userType);
        return userService.addUser(userDTO,userType);
    }
}
