package com.birdiebuddy.birdiebuddy.AskPage.Repository;

import com.birdiebuddy.birdiebuddy.AskPage.DTO.AnswerDTO;
import com.birdiebuddy.birdiebuddy.AskPage.Entity.AnswerToAsk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerToAsk, Long> {
    //댓글 검색
    Optional<AnswerToAsk> findById(Long id);
}