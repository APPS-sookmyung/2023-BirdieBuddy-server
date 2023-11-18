package com.birdiebuddy.birdiebuddy.AskPage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Table(name = "Ask")
@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Ask {
    //게시글 id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    //작성자 (외래 키)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // User table의 user_id 참조하고 싶어요
    private Long userKey;

    //게시글 내용
    @Column
    private String content;

    //제목
    @Column
    private String title;

    //작성일
    @Column
    private String date;
}
