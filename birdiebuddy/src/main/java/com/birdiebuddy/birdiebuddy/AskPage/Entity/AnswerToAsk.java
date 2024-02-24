package com.birdiebuddy.birdiebuddy.AskPage.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

@Table(name = "AnswerToAsk")
@Entity
@Getter
@SuperBuilder
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnswerToAsk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long answerId;

    //소속된 ASK의 id
    @JoinColumn(name = "askId")
    private Long askId;

    //작성 날짜, 시간
    @Column
    private String date;

    @Column
    private String content;

    //댓글이면 false, 대댓글이면 true
    @Column
    private boolean isChild;

    //대댓글일 경우 소속된 댓글의 id
    @Column
    private Long parentId;

    @JoinColumn(name = "user_id")
    private Long user;

    public void update(String content)
    {
        this.content = content;
    }
}