package com.example.seas.person.mapper;


import com.example.seas.event.mapper.EventSurveyQuestionMapper;
import com.example.seas.person.dto.ParticipantDTO;
import com.example.seas.person.entity.Participant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses ={ParticipantsInEventsMapper.class,
        EventSurveyQuestionMapper.class})
public interface ParticipantMapper {
    ParticipantDTO mapToDto(Participant participant);

    Participant mapToEntity(ParticipantDTO participantDTO);

    List<ParticipantDTO> mapToDto(List<Participant> participantList);

    List<Participant> mapToEntity(List<ParticipantDTO> participantDTOList);
}
