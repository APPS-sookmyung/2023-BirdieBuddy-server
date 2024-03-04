package com.birdiebuddy.birdiebuddy.record.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RecordDTO {
    private String location;
    private String content;
    private int count;
    private List<String> imageUrls;
    private LocalDateTime createdDate;
}
