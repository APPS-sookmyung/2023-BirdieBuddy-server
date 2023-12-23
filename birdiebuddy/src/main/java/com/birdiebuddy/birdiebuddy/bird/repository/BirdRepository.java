package com.birdiebuddy.birdiebuddy.bird.repository;

import com.birdiebuddy.birdiebuddy.bird.entity.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BirdRepository extends JpaRepository<Bird,Long> {
    List<Bird> findAll();

    @Override
    Optional<Bird> findById(Long id);

    List<Bird> findBirdsByClassed(String classed);
}
