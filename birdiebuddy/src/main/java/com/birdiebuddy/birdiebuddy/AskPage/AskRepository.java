//package com.birdiebuddy.birdiebuddy.AskPage;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface AskRepository extends JpaRepository<Ask, Long> {
//    //글 검색
//    Optional<Ask> findById(Long id);
//
//    Optional<List<Ask>> findByUser(Long userKey);
//
//    Optional<List<Ask>> findByTitle(String title);
//
//    //글 수정
//    Optional<Ask> update();
//
//}
