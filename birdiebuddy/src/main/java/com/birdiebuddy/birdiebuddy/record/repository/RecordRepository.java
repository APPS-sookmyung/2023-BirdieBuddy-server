package com.birdiebuddy.birdiebuddy.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record,Long> {
    //모든 record 조회
    List<Record> findAll();




}
