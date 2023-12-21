package com.birdiebuddy.birdiebuddy.entity;

import com.birdiebuddy.birdiebuddy.entity.Bird;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Table(name="bird_habitat")
public class Bird_habitat {
    private final EntityManager em;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private Bird table_id;
    private int habitat;
}
