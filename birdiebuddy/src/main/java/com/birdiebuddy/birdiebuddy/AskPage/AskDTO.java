package com.birdiebuddy.birdiebuddy.AskPage;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AskDTO {
    private Long postId;
    private Long userKey; //작성자
    private String content;
    private String title;
    private String date;

    @Builder
    public AskDTO(Ask ask)
    {
        this.postId = ask.getPostId();
        this.userKey = ask.getUserKey();
        this.content = ask.getContent();
        this.title = ask.getTitle();
        this.date = ask.getDate();
    }

    public Ask toEntity()
    {
        return Ask.builder()
                .userKey(userKey)
                .postId(postId)
                .content(content)
                .title(title)
                .date(date)
                .build();
    }

    public void update(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
