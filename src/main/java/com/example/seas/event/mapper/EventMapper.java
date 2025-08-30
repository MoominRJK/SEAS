package com.example.seas.event.mapper;

import java.util.*;

import com.example.seas.event.dto.EventDTO;
import com.example.seas.event.entity.Event;
import com.example.seas.person.mapper.ParticipantsInEventsMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {ParticipantsInEventsMapper.class,
        EventQuestionsMapper.class, EventSurveyQuestionMapper.class})
public interface EventMapper {

    @Mapping(source = "eventQuestions", target = "eventQuestions")
    @Mapping(source = "eventSurveyQuestions", target = "eventSurveyQuestions")
    EventDTO mapToDto(Event event);

    @Mapping(source = "eventQuestions", target = "eventQuestions")
    @Mapping(source = "eventSurveyQuestions", target = "eventSurveyQuestions")
    Event mapToEntity(EventDTO eventDTO);

    List<EventDTO> mapToDto(List<Event> eventList);

    List<Event> mapToEntity(List<EventDTO> eventDTOList);

}
