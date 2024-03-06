package com.birdiebuddy.birdiebuddy.user.service;

import com.birdiebuddy.birdiebuddy.user.dto.UserDto;
import com.birdiebuddy.birdiebuddy.user.entity.User;
import com.birdiebuddy.birdiebuddy.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional(readOnly=false)
public class SaveService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public long save(@RequestBody UserDto userDto){
        Optional<User> isDuplicated = userRepository.findByEmail(userDto.toEntity().getEmail());
        if (!isDuplicated.isEmpty()){
            throw new IllegalStateException("Existing user");
        }
        // User 객체 생성 시 id를 직접 설정하지 않고, JPA가 자동으로 생성하도록 함
        User user = User.builder()
                .email(userDto.getEmail())
                .pw(bCryptPasswordEncoder.encode(userDto.getPw()))
                .build();

        // UserRepository.save() 메서드를 호출하여 User 객체 저장
        User savedUser = userRepository.save(user);

        // 저장된 User 객체의 id 값을 반환
        return savedUser.getId();
//        return userRepository.save(User.builder()
//                .email(userDto.getEmail())
//                .pw(bCryptPasswordEncoder.encode(userDto.getPw()))
//                .build()).getId();
    }
}
