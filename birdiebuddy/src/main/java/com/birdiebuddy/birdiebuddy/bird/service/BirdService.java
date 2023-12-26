package com.birdiebuddy.birdiebuddy.bird.service;

import com.birdiebuddy.birdiebuddy.bird.repository.BirdRepository;
import com.birdiebuddy.birdiebuddy.bird.entity.Bird;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BirdService {
    private final BirdRepository birdRepository;

    //새 전체 조회
    public List<Bird> findBirds(){
        return birdRepository.findAll();
    }

    //특정 새 조회
    public Optional<Bird> findBird(Long id){
        return birdRepository.findById(id);
    }

    //classed로 새 조회
    public List<Bird> findByClass(String classed){
        return birdRepository.findBirdsByClassed(classed);
    }
}
