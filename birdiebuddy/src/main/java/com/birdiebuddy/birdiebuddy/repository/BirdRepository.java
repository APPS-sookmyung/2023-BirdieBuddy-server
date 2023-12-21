package com.birdiebuddy.birdiebuddy.repository;



import com.birdiebuddy.birdiebuddy.entity.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BirdRepository extends JpaRepository<Bird,Long> {
    List<Bird> findAll();
}
