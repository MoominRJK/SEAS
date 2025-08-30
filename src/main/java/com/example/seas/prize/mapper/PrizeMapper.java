package com.example.seas.prize.mapper;


import com.example.seas.event.mapper.EventSurveyQuestionMapper;
import com.example.seas.person.mapper.ParticipantsInEventsMapper;
import com.example.seas.prize.dto.PrizeDTO;
import com.example.seas.prize.entity.Prize;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses ={ParticipantsInEventsMapper.class,
        EventSurveyQuestionMapper.class})
public interface PrizeMapper {
    PrizeDTO mapToDto(Prize prize);

    Prize mapToEntity(PrizeDTO prizeDTO);

    List<PrizeDTO> mapToDto(List<Prize> PrizeList);

    List<Prize> mapToEntity(List<PrizeDTO> PrizeDTOList);

//    QuarterRaffleWinner getQuarterRaffleWinner(String year, String quarter);
}
