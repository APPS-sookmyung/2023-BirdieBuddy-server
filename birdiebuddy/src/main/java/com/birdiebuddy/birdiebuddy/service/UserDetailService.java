package com.birdiebuddy.birdiebuddy.service;

import com.birdiebuddy.birdiebuddy.entity.User;
import com.birdiebuddy.birdiebuddy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

//spring security에서 사용자 정보 가져오는 인터페이스
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    //사용자 이름(email)로 사용자 정보 가져오는 메서드
    @Override
    public User loadUserByUsername(String email){
        return userRepository.findByEmail(email).orElseThrow(()-> new IllegalArgumentException((email)));
    }
}
