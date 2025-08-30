package com.example.seas.person.controller;

import com.example.seas.event.entity.Event;
import com.example.seas.event.service.EventService;
import com.example.seas.person.entity.ParticipationCountInADay;
import com.example.seas.person.service.ParticipantsInEventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated

public class ParticipantsInEventsController {

    private final EventService eventService;
    private final ParticipantsInEventsService participantsInEventsService;


    @GetMapping("/participationDatesAndparticipantCounts/{eventName}")
    @PreAuthorize("hasAuthority('ORGANIZATOR')")
    public List<ParticipationCountInADay> getPartipationDatesAndParticipantCountsOfEvent
            (@PathVariable String eventName) {

        Event event = eventService.getEventByName(eventName);
        List<ParticipationCountInADay> partipationDatesAndParticipantCountsOfEvent =
                participantsInEventsService.getPartipationDatesAndParticipantCountsOfEvent(event);
        return partipationDatesAndParticipantCountsOfEvent;
    }

}
