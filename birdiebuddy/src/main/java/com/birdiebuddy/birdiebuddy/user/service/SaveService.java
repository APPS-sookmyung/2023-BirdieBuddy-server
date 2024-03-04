package com.birdiebuddy.birdiebuddy.user.service;

import com.birdiebuddy.birdiebuddy.user.dto.UserDto;
import com.birdiebuddy.birdiebuddy.user.entity.User;
import com.birdiebuddy.birdiebuddy.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SaveService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public long save(UserDto userDto){
        Optional<User> isDuplicated = userRepository.findByEmail(userDto.toEntity().getEmail());
        if (!isDuplicated.isEmpty()){
            throw new IllegalStateException("Existing user");
        }
        return userRepository.save(User.builder()
                .email(userDto.getEmail())
                .pw(bCryptPasswordEncoder.encode(userDto.getPw()))
                .build()).getId();
    }
}
