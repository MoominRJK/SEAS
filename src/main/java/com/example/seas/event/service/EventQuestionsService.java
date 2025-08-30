package com.example.seas.event.service;

import com.example.seas.common.MessageResponse;
import com.example.seas.event.entity.Event;
import com.example.seas.event.entity.EventQuestions;
import com.example.seas.event.repository.EventQuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.seas.common.enums.MessageType.SUCCESS;
import static com.example.seas.common.enums.MessageType.ERROR;

@Service
@RequiredArgsConstructor
public class EventQuestionsService {

    private final EventQuestionsRepository eventQuestionsRepository;
    private final EventService eventService;
    public MessageResponse addQuestionsToEvent(String eventName, List<EventQuestions> eventQuestions) {
        Event event = eventService.getEventByName(eventName);

        if(event == null){
            return new MessageResponse("Add question failed", ERROR);
        }
        else{
            event.setEventQuestions(eventQuestions.stream().collect(Collectors.toSet()));
            eventService.save(event);
            return new MessageResponse("Add question successful", SUCCESS);
        }
    }
    public List<EventQuestions> getAllQuestionsOfEvent(String eventName) {
        Event event = eventService.getEventByName(eventName);
        return eventQuestionsRepository.findAllByEventId(event.getId());

    }

    public void save(EventQuestions eventQuestion) {
        eventQuestionsRepository.save(eventQuestion);
    }
}
