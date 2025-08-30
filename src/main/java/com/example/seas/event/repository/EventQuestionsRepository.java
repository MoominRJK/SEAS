package com.example.seas.event.repository;

import com.example.seas.event.entity.EventQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventQuestionsRepository extends JpaRepository<EventQuestions,Integer> {


    @Query(
            value = "SELECT * FROM event_questions eq WHERE eq.event_id = :event_id",
            nativeQuery = true)
    List<EventQuestions> findAllByEventId(@Param("event_id") int event_id);
}
