package com.birdiebuddy.birdiebuddy.AskPage.Repository;

import com.birdiebuddy.birdiebuddy.AskPage.DTO.AskDTO;
import com.birdiebuddy.birdiebuddy.AskPage.Entity.Ask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long> {
    //글 검색
    Optional<Ask> findById(Long id);
    List<Ask> findAll();
    Optional<List<Ask>> findByUserKey(Long userKey);
    Optional<List<Ask>> findByTitle(String title);
}
