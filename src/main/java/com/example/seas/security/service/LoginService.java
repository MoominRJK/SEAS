package com.example.seas.security.service;

import com.example.seas.common.LoginResponse;
import com.example.seas.common.MessageResponse;
import com.example.seas.common.enums.MessageType;
import com.example.seas.security.dto.LoginRequestDTO;
import com.example.seas.security.entity.Users;
import com.example.seas.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final CustomUserDetailsService customUserDetailsService;
    private final AuthenticationProvider authenticationProvider;

    @Value("${security.jwt.secret-key}")
    private String secretKey;
    private MessageResponse messageResponse;

    public LoginResponse login(LoginRequestDTO loginRequestDTO) {
        try {
            Users user = (Users) customUserDetailsService.loadUserByUsername(loginRequestDTO.getUsername());
            var authenticationToken = new UsernamePasswordAuthenticationToken(
                    user.getUsername(), loginRequestDTO.getPassword());
            Authentication authentication = authenticationProvider.authenticate(authenticationToken);
            String jwtToken =  JwtUtil.generateToken(authentication,secretKey,7);
            messageResponse = new MessageResponse("Login successfully. You are being redirected",
                                                        MessageType.SUCCESS);
            return new LoginResponse(jwtToken,messageResponse, user.getName() + " " +user.getSurname());
        } catch (Exception ex) {
               ex.printStackTrace();
        }
        messageResponse = new MessageResponse("The information you entered is incorrect! Please re-enter.",
                MessageType.ERROR);
        return new LoginResponse(null,messageResponse , "NoBody");
    }

}
