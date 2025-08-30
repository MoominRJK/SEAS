package com.example.seas.prize.entity;

import com.example.seas.person.entity.Participant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@IdClass(com.example.seas.prize.pkclasses.ParticipantsPrizePK.class)
@NoArgsConstructor

public class ParticipantsPrize {

    @Id
    @ManyToOne
    @JoinColumn(name = "prize_id", referencedColumnName = "id",nullable = false)
    private Prize prize;

    @Id
    @ManyToOne
    @JoinColumn(name = "participant_id", referencedColumnName = "id",nullable = false)
    private Participant participant;

    @Column(name = "Year")
    private int year;

    @Column(name = "QUARTER")
    private int quarter;

    @Column(name = "GRADE")
    private int grade;

    public ParticipantsPrize(Prize prize, Participant participant, int year, int quarter, int grade) {
        this.prize = prize;
        this.participant = participant;
        this.year = year;
        this.quarter = quarter;
        this.grade = grade;
    }
}
