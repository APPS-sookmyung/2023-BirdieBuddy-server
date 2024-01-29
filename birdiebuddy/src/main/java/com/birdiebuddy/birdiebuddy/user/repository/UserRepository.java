package com.birdiebuddy.birdiebuddy.user.repository;

import com.birdiebuddy.birdiebuddy.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // email로 사용자 식별 가능, 즉 사용자 이름 = email.

    List<User> findAll();
    
}
