package com.birdiebuddy.birdiebuddy.AskPage.DTO;

import com.birdiebuddy.birdiebuddy.AskPage.Entity.Ask;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class AskDTO {
    private Long askId;
    private Long userKey; //작성자
    private String content;
    private String title;
    private String date;

    private List<Long> answerList;

    @Builder
    public AskDTO(Ask ask)
    {
        this.askId = ask.getAskId();
        this.userKey = ask.getUserKey();
        this.content = ask.getContent();
        this.title = ask.getTitle();
        this.date = ask.getDate();
    }

    public Ask toEntity()
    {
        return Ask.builder()
                .userKey(userKey)
                .askId(askId)
                .content(content)
                .title(title)
                .date(date)
                .answerList(answerList)
                .build();
    }

    public void update(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
