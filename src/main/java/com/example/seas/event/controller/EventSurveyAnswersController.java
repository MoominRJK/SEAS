package com.example.seas.event.controller;

import com.example.seas.common.MessageResponse;
import com.example.seas.event.dto.EventDTO;
import com.example.seas.event.dto.SurveyDTO.EventSurveyAnswerDTO;
import com.example.seas.event.entity.Event;
import com.example.seas.event.entity.Survey.EventSurveyAnswers;
import com.example.seas.event.mapper.EventMapper;
import com.example.seas.event.mapper.EventSurveyAnswersMapper;
import com.example.seas.event.service.EventSurveyAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class EventSurveyAnswersController {
    private final EventSurveyAnswersMapper surveyAnswersMapper;
    private final EventSurveyAnswerService surveyAnswerService;
    private final EventMapper eventMapper;

    @PostMapping("/sendSurveyAnswersOf/{eventName}")
    @PreAuthorize("hasAuthority('PARTICIPANT')")
    public MessageResponse addAnswersToSurveyQuestions(@PathVariable String eventName,
            @RequestBody @Valid List<EventSurveyAnswerDTO> surveyAnswersDTOList) {
        List<EventSurveyAnswers> surveyAnswers =
                surveyAnswersMapper.mapToEntity(surveyAnswersDTOList);
        return surveyAnswerService.addAnswersToSurveyQuestions(surveyAnswers,eventName);

    }

    @PostMapping("/isAnsweredToSurveyBefore/{participantUsername}")
    @PreAuthorize("hasAuthority('PARTICIPANT')")
    public boolean isAnsweredBeforeToSurveyQuestions(@PathVariable String participantUsername,
                                                     @RequestBody @Valid EventDTO eventDTO) {
        Event event = eventMapper.mapToEntity(eventDTO);
        return surveyAnswerService.isAnsweredBeforeToSurveyQuestions(participantUsername,event);
    }
}
