package com.example.seas.prize.service;

import com.example.seas.person.entity.ParticipantsPoint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;


@SpringBootTest
class ParticipantsPrizeServiceTest {

    @Autowired
    ParticipantsPrizeService participantsPrizeService;
    @Test
    @Transactional
    @Rollback(true)
    void generateQuarterPrizeWinner() {
        List<ParticipantsPoint> a =  participantsPrizeService.generateQuarterPrizeWinner(2022, 4, false);

        System.out.println(a);
    }
}