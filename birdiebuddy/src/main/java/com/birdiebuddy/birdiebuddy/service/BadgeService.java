package com.birdiebuddy.birdiebuddy.service;

import com.birdiebuddy.birdiebuddy.entity.Badge;
import com.birdiebuddy.birdiebuddy.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeService {
    @Autowired
    BadgeRepository badgeRepository;

    public List<Badge> getAllBadges(){
        return badgeRepository.findAll();
    }
}
