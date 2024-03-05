package com.birdiebuddy.birdiebuddy.user.service;

import com.birdiebuddy.birdiebuddy.user.dto.UserDto;
import com.birdiebuddy.birdiebuddy.user.entity.User;
import com.birdiebuddy.birdiebuddy.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional(readOnly=true)
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(email));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), Collections.emptyList());
    } // 사용자 조회 (by email)

    @Transactional(readOnly = false)
    public String login(String email, String pw){
        Optional<User> user = userRepository.findByEmail(email);
        User you = user.get();

        log.info("db password = {}, input password= = {}", you.getPw(), pw);
        if (you.getPw().equals(pw)){
            return "Success";
        }
        return "Failed";
    } // 로그인 (by email)

    public UserDto findById(Long id){
        User entity = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No Such User id = " + id));
        return new UserDto(entity);
    } // 조회

    public Long update(Long id, UserDto userDto){
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No Such User id = " + id));
        user.update(userDto.getImage());
        return id;
    } // 수정

    public List<User> findAll(){
        return userRepository.findAll();
    } // user 전체 조회


}
