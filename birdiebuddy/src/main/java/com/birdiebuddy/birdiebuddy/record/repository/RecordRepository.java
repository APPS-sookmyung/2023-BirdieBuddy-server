package com.birdiebuddy.birdiebuddy.record.repository;

import com.birdiebuddy.birdiebuddy.record.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record,Long> {
    //모든 record 조회
    List<Record> findAll();

    // 레코드 저장
    Record save(Record record);
}
