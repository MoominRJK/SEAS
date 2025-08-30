package com.example.seas.question.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
public class QuestionDTO {

    @JsonProperty("question")
    public final String question;

    @JsonCreator
    public QuestionDTO(@JsonProperty("question") String question) {
        this.question = question;
    }



}
