package com.example.seas.person.mapper;


import com.example.seas.event.mapper.EventMapper;
import com.example.seas.person.dto.ParticipantsInEventsDTO;
import com.example.seas.person.entity.ParticipantsInEvents;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = {EventMapper.class,ParticipantMapper.class})
public interface ParticipantsInEventsMapper {

    ParticipantsInEvents INSTANCE = Mappers.getMapper(ParticipantsInEvents.class);

    @Mapping(source = "participant", target = "participant")
    @Mapping(source = "event", target = "event")
    ParticipantsInEventsDTO mapToDto(ParticipantsInEvents participantsInEvents);

    @Mapping(source = "participant",target = "participant")
    @Mapping(source = "event",target = "event")
    ParticipantsInEvents mapToEntity( ParticipantsInEventsDTO participantsInEventsDTO);

    List<ParticipantsInEventsDTO> mapToDto(List<ParticipantsInEvents> participantsInEvents);

    List<ParticipantsInEvents> mapToEntity(List<ParticipantsInEventsDTO> participantsInEventsDTOList);
}
