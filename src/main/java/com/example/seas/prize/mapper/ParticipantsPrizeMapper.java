package com.example.seas.prize.mapper;


import com.example.seas.person.mapper.ParticipantMapper;
import com.example.seas.prize.dto.ParticipantsPrizeDTO;
import com.example.seas.prize.entity.ParticipantsPrize;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PrizeMapper.class, ParticipantMapper.class})
public interface ParticipantsPrizeMapper {

    ParticipantsPrize INSTANCE = Mappers.getMapper(ParticipantsPrize.class);

    @Mapping(source = "participant", target = "participant")
    @Mapping(source = "prize", target = "prize")
    ParticipantsPrizeDTO mapToDto(ParticipantsPrize participantsPrize);

    @Mapping(source = "participant",target = "participant")
    @Mapping(source = "prize",target = "prize")
    ParticipantsPrize mapToEntity( ParticipantsPrizeDTO participantsPrizeDTO);

    List<ParticipantsPrizeDTO> mapToDto(List<ParticipantsPrize> participantsPrize);

    List<ParticipantsPrize> mapToEntity(List<ParticipantsPrizeDTO> participantsPrizeDTOList);
}
