package com.birdiebuddy.birdiebuddy.user.service;

import com.birdiebuddy.birdiebuddy.user.entity.Badge;
import com.birdiebuddy.birdiebuddy.user.repository.BadgeRepository;
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
