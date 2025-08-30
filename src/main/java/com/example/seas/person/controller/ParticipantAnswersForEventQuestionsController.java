package com.example.seas.person.controller;

import java.util.*;
import com.example.seas.common.MessageResponse;
import com.example.seas.person.service.ParticipantAnswersForEventQuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/answersOfEvent")
public class ParticipantAnswersForEventQuestionsController {

    private final ParticipantAnswersForEventQuestionsService participantAnswersForEventQuestionsService;

    @PostMapping("/{eventName}/{username}")
    @PreAuthorize("hasAuthority('PARTICIPANT')")
    public MessageResponse answerTheQuestionsOfEvent(
            @PathVariable String eventName,
            @PathVariable String username,
            @RequestBody @Valid List<String> answers) {
        return participantAnswersForEventQuestionsService.answerTheQuestionsOfEvent(eventName,username,answers);
    }

    @GetMapping("/{eventName}/for/{username}")
    @PreAuthorize("hasAuthority('PARTICIPANT')")
    public List<String> getParticipantAnswers(@PathVariable String eventName,
                                              @PathVariable String username) {
        List<String> answers = participantAnswersForEventQuestionsService.getParticipantAnswers(eventName,username);
        return answers;
    }

    @GetMapping("/{eventName}/{username}")
    @PreAuthorize("hasAuthority('PARTICIPANT')")
    public boolean isParticipantAlreadyAnsweredToQuestions(@PathVariable String eventName,
                                                           @PathVariable String username) {
        List<String> answers = participantAnswersForEventQuestionsService.getParticipantAnswers(eventName,username);
        return hasAnyAnswer(answers);

    }

    private boolean hasAnyAnswer(List<String> answers) {
        return answers.size() > 0;
    }


}
