package com.example.seas.prize.controller;

import com.example.seas.prize.dto.ParticipantsPointDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

@SpringBootTest
class PrizeControllerTest {

    @Autowired
    PrizeController prizeController;
    @Test
    @Transactional
    @Rollback(true)
    void getQuarterParticipantsPoint() {

        List<ParticipantsPointDTO> participantsPointDTOList = prizeController.getQuarterParticipantsPoint(2022,4);

        System.out.println(participantsPointDTOList);
    }
}