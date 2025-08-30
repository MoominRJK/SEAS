package com.example.seas.prize.mapper;


import com.example.seas.event.mapper.EventSurveyQuestionMapper;
import com.example.seas.person.entity.ParticipantsPoint;
import com.example.seas.person.mapper.ParticipantsInEventsMapper;
import com.example.seas.prize.dto.ParticipantsPointDTO;
import com.example.seas.prize.dto.PrizeDTO;
import com.example.seas.prize.entity.Prize;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses ={ParticipantsInEventsMapper.class,
        EventSurveyQuestionMapper.class})
public interface ParticipantsPointMapper {
    ParticipantsPointDTO mapToDto(ParticipantsPoint prize);

    Prize mapToEntity(PrizeDTO prizeDTO);

    List<ParticipantsPointDTO> mapToDto(List<ParticipantsPoint> participantsPointList);



//    QuarterRaffleWinner getQuarterRaffleWinner(String year, String quarter);
}
