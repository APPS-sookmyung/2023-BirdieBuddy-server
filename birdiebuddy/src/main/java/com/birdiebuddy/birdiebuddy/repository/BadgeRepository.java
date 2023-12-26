package com.birdiebuddy.birdiebuddy.repository;

import com.birdiebuddy.birdiebuddy.entity.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {
}
