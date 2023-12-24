package com.birdiebuddy.birdiebuddy.service;

import com.birdiebuddy.birdiebuddy.dto.UserDto;
import com.birdiebuddy.birdiebuddy.entity.User;
import com.birdiebuddy.birdiebuddy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional(readOnly=true)
public class UserService {
    private final UserRepository userRepository;

    //email로 로그인
    @Transactional(readOnly = false)
    public String login(String email, String pw){
        //LocalDate localDate = LocalDate.now();
        Optional<User> user = userRepository.findByEmail(email);
        User you = user.get();

        log.info("db password = {}, input password= = {}", user.get().getPw(), pw);
        if (user.get().getPw().equals(pw)){
            return "Success";
        }
        return "Failed";
    }
    //email로 조회

    //user 세이브?
    public long save(UserDto userDto){
        return userRepository.save(userDto.toEntity()).getId();
    }

    //조회
    public UserDto findById(Long id){
        User entity = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No Such User id = " + id));
        return new UserDto(entity);
    }

    //수정
    public Long update(Long id, UserDto userDto){
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No Such User id = " + id));
        user.update(userDto.getImage());
        return id;
    }

    //user 조회
    public List<User> findAll(){
        return userRepository.findAll();
    }


}
