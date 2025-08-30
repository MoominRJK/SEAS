package com.example.seas.event.mapper;

import com.example.seas.event.dto.EventQuestionsDTO;
import com.example.seas.event.entity.EventQuestions;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventQuestionsMapper {
    EventQuestionsDTO mapToDto(EventQuestions eventQuestion);

    EventQuestions mapToEntity( EventQuestionsDTO eventQuestionDTO);

    List<EventQuestionsDTO> mapToDto(List<EventQuestions> eventQuestionList);

    List<EventQuestions> mapToEntity(List< EventQuestionsDTO> eventQuestionDTOList);
}
