package com.example.seas.common;

import com.example.seas.common.enums.MessageType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MessageResponse {
    public  String message;
    public  MessageType messageType;
}
