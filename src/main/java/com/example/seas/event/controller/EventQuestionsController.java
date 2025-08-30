package com.example.seas.event.controller;

import com.example.seas.common.MessageResponse;
import com.example.seas.event.dto.EventQuestionsDTO;
import com.example.seas.event.entity.EventQuestions;
import com.example.seas.event.mapper.EventQuestionsMapper;
import com.example.seas.event.service.EventQuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/questionsOfEvent")
public class EventQuestionsController {

    private final EventQuestionsService eventQuestionsService;
    private final EventQuestionsMapper eventQuestionsMapper;

    @PostMapping("/{eventName}")
    @PreAuthorize("hasAuthority('ORGANIZATOR')")
    public MessageResponse addQuestionsToEvent(@PathVariable String eventName,
                                    @RequestBody @Valid List<EventQuestionsDTO> eventQuestionsDTO) {
        List<EventQuestions> eventQuestions = eventQuestionsMapper.mapToEntity(eventQuestionsDTO);
        return eventQuestionsService.addQuestionsToEvent(eventName,eventQuestions);

    }
    @GetMapping("/{eventName}")
    public List<EventQuestionsDTO> getQuestionsOfEvent(@PathVariable String eventName) {
        List<EventQuestions> eventQuestions = eventQuestionsService.getAllQuestionsOfEvent(eventName);
        return eventQuestionsMapper.mapToDto(eventQuestions);
    }

}
