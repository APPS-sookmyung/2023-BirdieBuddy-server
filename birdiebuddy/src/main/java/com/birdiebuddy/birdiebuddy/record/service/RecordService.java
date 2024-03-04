package com.birdiebuddy.birdiebuddy.record.service;

import com.birdiebuddy.birdiebuddy.record.dto.RecordDTO;
import com.birdiebuddy.birdiebuddy.record.entity.Record;
import com.birdiebuddy.birdiebuddy.record.entity.RecordImage;
import com.birdiebuddy.birdiebuddy.record.repository.RecordImageRepository;
import com.birdiebuddy.birdiebuddy.record.repository.RecordRepository;
import com.birdiebuddy.birdiebuddy.user.entity.User;
import com.birdiebuddy.birdiebuddy.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final RecordImageRepository recordImageRepository;
    private final UserRepository userRepository;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10); // 최대 10개의 스레드를 가지는 스레드 풀

    //기록 전체 조회
    public List<Record> findAllRecords(){
        return recordRepository.findAll();
    }


    // 기록 등록
    @Transactional
    public List<Long> record(String email, List<RecordDTO> recordDTOs) {
        // 유저 찾기
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            // 유저가 존재하지 않는 경우 처리
            throw new RuntimeException("User not found with email: " + email);
        }

        // 그룹 ID 생성을 위한 변수
        long groupId = System.currentTimeMillis();

        List<Callable<Long>> tasks = new ArrayList<>();

        for (RecordDTO recordDTO : recordDTOs) {
            tasks.add(() -> {
                Record record=new Record();

                record.setLocation(recordDTO.getLocation());
                record.setContent(recordDTO.getContent());
                record.setCount(recordDTO.getCount());
                record.setUser_id(user.get());
                record.setGroup_id(groupId); // 같은 스레드에 속하는 기록을 그룹화하기 위해 그룹 ID 설정

                // 기록 저장
                Record savedRecord = recordRepository.save(record);

                // 기록에 대한 이미지 처리
                for (String imageUrl : recordDTO.getImageUrls()) {
                    RecordImage recordImage = new RecordImage();
                    recordImage.setPost_id(savedRecord);
                    recordImage.setImage(imageUrl);
                    recordImageRepository.save(recordImage);
                }

                return savedRecord.getId();
            });
        }

        try {
            // 모든 작업을 병렬로 실행하고 결과를 기다림
            List<Future<Long>> results = executorService.invokeAll(tasks);

            // 각 기록의 ID를 수집하여 반환
            List<Long> recordIds = new ArrayList<>();
            for (Future<Long> result : results) {
                recordIds.add(result.get());
            }

            return recordIds;
        } catch (Exception e) {
            // 예외 처리
            throw new RuntimeException("Error occurred while processing records: " + e.getMessage(), e);
        }
    }
}
