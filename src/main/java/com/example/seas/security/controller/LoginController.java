package com.example.seas.security.controller;

import com.example.seas.common.LoginResponse;
import com.example.seas.security.dto.LoginRequestDTO;
import com.example.seas.security.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return loginService.login(loginRequestDTO);
    }
}
