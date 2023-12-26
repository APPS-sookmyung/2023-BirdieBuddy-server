package com.birdiebuddy.birdiebuddy.badge;

import com.birdiebuddy.birdiebuddy.entity.Badge;
import com.birdiebuddy.birdiebuddy.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BadgeList {
    @Autowired
    BadgeService badgeService;

    @GetMapping("/badgelist")
    public List<Badge> getAllBadges(){
        List<Badge> badges = badgeService.getAllBadges();
        return badges;
    }
}
