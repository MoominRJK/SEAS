package com.example.seas.person.mapper;


import com.example.seas.person.dto.ParticipantAnswersForEventQuestionsDTO;
import com.example.seas.person.entity.ParticipantAnswersForEventQuestions;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParticipantAnswersForEventQuestionsMapper {
    ParticipantAnswersForEventQuestionsDTO mapToDto(ParticipantAnswersForEventQuestions answers);

    ParticipantAnswersForEventQuestions mapToEntity(ParticipantAnswersForEventQuestionsDTO answersDTO);

    List<ParticipantAnswersForEventQuestionsDTO> mapToDto(List<ParticipantAnswersForEventQuestions> answerList);

    List<ParticipantAnswersForEventQuestions> mapToEntity(List<ParticipantAnswersForEventQuestionsDTO> answerDTOList);
}
