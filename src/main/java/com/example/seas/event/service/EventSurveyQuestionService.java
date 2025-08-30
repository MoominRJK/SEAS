package com.example.seas.event.service;

import com.example.seas.common.MessageResponse;
import com.example.seas.event.entity.Event;
import com.example.seas.event.entity.Survey.EventSurveyQuestions;
import com.example.seas.event.entity.Survey.SurveyStatistics;
import com.example.seas.event.repository.EventSurveyQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.seas.common.enums.MessageType.ERROR;
import static com.example.seas.common.enums.MessageType.SUCCESS;

@Service
@RequiredArgsConstructor
public class EventSurveyQuestionService {

    private final EventSurveyQuestionRepository surveyQuestionRepository;
    private final EventService eventService;
    public MessageResponse addSurveyQuestionsToEvent(String eventName,
                                                     List<EventSurveyQuestions> surveyQuestions) {
        Event event = eventService.getEventByName(eventName);

        if(event == null){
            return new MessageResponse("Add question failed", ERROR);
        }
        else{
            event.getEventSurveyQuestions().addAll(surveyQuestions);
            eventService.save(event);
            return new MessageResponse("Add question successful", SUCCESS);
        }
    }

    public void save(EventSurveyQuestions surveyQuestion) {
        surveyQuestionRepository.save(surveyQuestion);
    }

    public List<List<SurveyStatistics>> getSurveyStatistics(String eventName) {
        List<EventSurveyQuestions> allSurveyQuestionsOfEvent
                = getAllSurveyQuestionsOfEvent(eventName);
        List<List<SurveyStatistics>> surveyStatistics = new ArrayList<List<SurveyStatistics>>();
        for(int i = 0; i < allSurveyQuestionsOfEvent.size(); i++) {
            EventSurveyQuestions surveyQuestion = allSurveyQuestionsOfEvent.get(i);
            surveyStatistics.add(surveyQuestionRepository
                    .getStatisticsOfSurveyQuestion(surveyQuestion.getId()));
        }
        return surveyStatistics;
    }

    public List<EventSurveyQuestions> getAllSurveyQuestionsOfEvent(String eventName) {
        Event event = eventService.getEventByName(eventName);
        return surveyQuestionRepository.findAllByEventId(event.getId());
    }

    public List<EventSurveyQuestions> findAllByEventId(Integer id) {
        return surveyQuestionRepository.findAllByEventId(id);
    }
}
