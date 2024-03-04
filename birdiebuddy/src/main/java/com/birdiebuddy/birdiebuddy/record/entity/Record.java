package com.birdiebuddy.birdiebuddy.record.entity;

import com.birdiebuddy.birdiebuddy.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "record")
@Getter @Setter
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id") //연관관계 매핑
    private User user_id;

    @Column
    private Long group_id; //같은 게시글의 그룹인지
    @Column
    private String location; //위치
    private String bird; //종 명

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdDate; //등록일자

    @Column(columnDefinition = "TEXT")
    private String content; //설명

    @Column
    private int count; //새 카운트 수

    @Column
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<RecordImage> image; //이미지


}
