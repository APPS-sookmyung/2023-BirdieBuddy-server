package com.birdiebuddy.birdiebuddy.AskPage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long> {

    Long save(AskDTO askD);
    List<Ask> findAll();

    Optional<Ask> findById(Long id);

    Optional<List<Ask>> findByUser(Long userKey);

    Optional<List<Ask>> findByTitle(String title);

    Optional<Ask> update(Long id, AskDTO askD); //글 수정

    Optional<List<AnswerToAsk>> findMyAnswer(Long postId);

}
