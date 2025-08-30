package com.example.seas.person.entity;

import com.example.seas.event.entity.EventQuestions;
//import com.example.seas.event.;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@IdClass(com.example.seas.event.pkclasses.ParticipantAnswersForEventQuestionsPK.ParticipantAnswersForEventQuestionsPK.class)
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantAnswersForEventQuestions {

    @Column(name = "ANSWER",nullable = false)
    private String answer;

    @Id
    @ManyToOne
    @JoinColumn(name = "PARTICIPANT_ID", referencedColumnName = "id",nullable = false)
    private Participant participant;

    @Id
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "id",nullable = false)
    private EventQuestions questions ;
}
