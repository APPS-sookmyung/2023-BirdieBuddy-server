package com.birdiebuddy.birdiebuddy.record.repository;

import com.birdiebuddy.birdiebuddy.record.entity.RecordImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordImageRepository extends JpaRepository<RecordImage,Long> {
}
