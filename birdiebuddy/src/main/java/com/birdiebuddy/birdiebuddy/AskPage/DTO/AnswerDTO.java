package com.birdiebuddy.birdiebuddy.AskPage.DTO;

import com.birdiebuddy.birdiebuddy.AskPage.Entity.AnswerToAsk;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AnswerDTO {
    private Long answerId;
    private Long postId;
    private Long user;
    private String content;
    private String date;

    @Builder
    public AnswerDTO(AnswerToAsk answer)
    {
        this.answerId = answer.getAnswerId();
        this.postId = answer.getAskId();
        this.user = answer.getUser();
        this.content = answer.getContent();
        this.date = answer.getDate();
    }

    public AnswerToAsk ToEntity()
    {
        return AnswerToAsk.builder()
                .answerId(answerId)
                .askId(postId)
                .user(user)
                .content(content)
                .date(date)
                .build();
    }
}
