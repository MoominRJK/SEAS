package com.example.seas.person.controller;


import com.example.seas.common.MessageResponse;
import com.example.seas.event.entity.Event;
import com.example.seas.event.service.EventService;
import com.example.seas.person.dto.ParticipantQuestionsAboutEventDTO;
import com.example.seas.person.entity.ParticipantQuestionsAboutEvent;
import com.example.seas.person.service.ParticipantQuestionsService;
import com.example.seas.question.mapper.ParticipantQuestionMapper;
import lombok.RequiredArgsConstructor;
import java.util.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class ParticipantQuestionsController {

    private final ParticipantQuestionsService participantQuestionsService;
    private final EventService eventService;
    private final ParticipantQuestionMapper participantQuestionMapper;

    @PostMapping("/sendParticipantQuestion/{questionText}")
    public MessageResponse sendParticipantQuestion(@PathVariable String questionText,
                       @Valid @RequestBody ParticipantQuestionsAboutEventDTO participantQuestionsAboutEventDTO) {
        ParticipantQuestionsAboutEvent participantQuestionAboutEvent =
                participantQuestionMapper.mapToEntity(participantQuestionsAboutEventDTO);
        return participantQuestionsService.sendParticipantQuestion(participantQuestionAboutEvent,questionText);

    }

    @GetMapping("/participantsQuestions/{eventName}")
    public List<ParticipantQuestionsAboutEventDTO> getParticipantsQuestions
            (@PathVariable String eventName) {
        Event event = eventService.getEventByName(eventName);
        List<ParticipantQuestionsAboutEvent> participantQuestions
                = participantQuestionsService.getParticipantQuestionsOf(event);
        return participantQuestionMapper.mapToDto(participantQuestions);

    }

    @PutMapping("/sendLecturerAnswer/")
    @PreAuthorize("hasAuthority('LECTURER')")
    public MessageResponse updateAnswerOfQuestionAsLecturerAnswer(
            @Valid @RequestBody ParticipantQuestionsAboutEventDTO participantQuestionsDTO) {
        ParticipantQuestionsAboutEvent participantQuestionAboutEvent =
                participantQuestionMapper.mapToEntity(participantQuestionsDTO);
        return participantQuestionsService.updateAnswerOfQuestion(participantQuestionAboutEvent);
    }

}
