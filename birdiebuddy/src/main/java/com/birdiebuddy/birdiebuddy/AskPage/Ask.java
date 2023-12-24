package com.birdiebuddy.birdiebuddy.AskPage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Table(name = "Ask")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

    //제목
    @Column
    private String title;

    //게시글 내용
    @Column
    private String content;

    //작성일
    @Column
    private String date;

    @Column
    private List<Long> answerList;

    public void update(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
