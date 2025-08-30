package com.example.seas.prize.dto;


import com.example.seas.person.dto.ParticipantDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ParticipantsPrizeDTO {

    @JsonProperty("prize")
    public final PrizeDTO prize;

    @JsonProperty("participant")
    public final ParticipantDTO participant;

    @JsonCreator
    public ParticipantsPrizeDTO(@JsonProperty("prize") PrizeDTO prize,
                                @JsonProperty("participant") ParticipantDTO participant) {
        this.prize = prize;
        this.participant = participant;
    }
}
