package com.birdiebuddy.birdiebuddy.bird.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Entity
@RequiredArgsConstructor
@Table(name="bird_habitat")
public class Bird_habitat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "bird_id", nullable = false)
//    private Bird bird_id;
    private int habitat;
}
