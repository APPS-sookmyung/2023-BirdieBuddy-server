package com.birdiebuddy.birdiebuddy.record.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recordImg")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecordImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Record post_id;

    @Column
    private String image;


}
