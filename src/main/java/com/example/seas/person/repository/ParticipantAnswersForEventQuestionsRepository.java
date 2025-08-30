package com.example.seas.person.repository;

import com.example.seas.person.entity.ParticipantAnswersForEventQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantAnswersForEventQuestionsRepository extends
        JpaRepository<ParticipantAnswersForEventQuestions,Integer> {

}
