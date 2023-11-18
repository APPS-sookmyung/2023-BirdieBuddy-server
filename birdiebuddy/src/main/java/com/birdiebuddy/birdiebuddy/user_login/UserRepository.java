package com.birdiebuddy.birdiebuddy.user_login;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByEmail(String email); // email로 사용자 식별 가능, 즉 사용자 이름 = email.
}
