package com.example.seas.event.mapper;

import com.example.seas.event.dto.SurveyDTO.EventSurveyAnswerDTO;
import com.example.seas.event.entity.Survey.EventSurveyAnswers;
import com.example.seas.person.mapper.ParticipantMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {EventSurveyQuestionMapper.class,
        ParticipantMapper.class})

public interface EventSurveyAnswersMapper {

    @Mapping(source = "participant", target = "participant")
    @Mapping(source = "eventSurveyQuestions", target = "eventSurveyQuestion")
    EventSurveyAnswerDTO mapToDto(EventSurveyAnswers surveyAnswer);

    @Mapping(source = "participant", target = "participant")
    @Mapping(source = "eventSurveyQuestion", target = "eventSurveyQuestions")
    EventSurveyAnswers mapToEntity(EventSurveyAnswerDTO surveyAnswerDTO);

    List<EventSurveyAnswerDTO> mapToDto(List<EventSurveyAnswers> surveyAnswerList);

    List<EventSurveyAnswers> mapToEntity(List<EventSurveyAnswerDTO> surveyAnswerDTOList);
}
