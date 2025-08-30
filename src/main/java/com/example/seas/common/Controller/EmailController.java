package com.example.seas.common.Controller;

import com.example.seas.common.service.EmailService;
import com.example.seas.event.dto.EventDTO;
import com.example.seas.event.entity.Event;
import com.example.seas.event.mapper.EventMapper;
import com.example.seas.person.entity.Participant;
import com.example.seas.person.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sendEmail")
public class EmailController {
    private final EmailService emailService;
    private final ParticipantService participantService;
    private final EventMapper eventMapper;

    @PostMapping("/{participantUsername}")
    public void sendEmailToParticipant(@PathVariable String participantUsername,
                                        @RequestBody @Valid EventDTO eventDTO) throws Exception {
        Event event = eventMapper.mapToEntity(eventDTO);
        Optional<Participant> optionalParticipant =
                participantService.findByUsername(participantUsername);
        if(optionalParticipant.isPresent()) {
            Participant participant = optionalParticipant.get();
            emailService.sendEmailWithQrCode(participant,event);
        }
    }

    @PostMapping("/toRaffleWinner/{participantUsername}")
    public void sendEmailToRaffleWinner(@PathVariable String participantUsername,
                                        @RequestBody @Valid EventDTO eventDTO) {
        Optional<Participant> optionalParticipant =
                participantService.findByUsername(participantUsername);
        Participant participant = optionalParticipant.get();
        Event event = eventMapper.mapToEntity(eventDTO);
        emailService.sendMailAboutEventRaffle(participant,event);
    }
}
