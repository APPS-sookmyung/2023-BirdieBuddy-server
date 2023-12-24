package com.birdiebuddy.birdiebuddy.AskPage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Table(name = "AnswerToAsk")
@Entity
@Getter
@SuperBuilder
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class AnswerToAsk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private String postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Long user;

    @Column
    private String content;

    //작성 날짜, 시간
    @Column
    private String date;

    @Column
    private List<Long> answerList;
}