package com.birdiebuddy.birdiebuddy.AskPage.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

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
    @Column
    private Long askId;

    //작성자 (외래 키)
    @JoinColumn(name = "user_id")
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

//    public void update(String title, String content)
//    {
//        this.title = title;
//        this.content = content;
//    }
}
