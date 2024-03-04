package com.birdiebuddy.birdiebuddy.record.service;

import com.birdiebuddy.birdiebuddy.record.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;

    //기록 전체 조회
    public List<Record> findAllRecords(){
        return recordRepository.findAll();
    }


}
