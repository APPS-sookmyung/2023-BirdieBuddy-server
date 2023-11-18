package com.birdiebuddy.birdiebuddy.Service;

import com.birdiebuddy.birdiebuddy.user_login.User;
import com.birdiebuddy.birdiebuddy.user_login.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    //email로 로그인
    @Transactional
    public String login(String userEmail, String pw){
        LocalDate localDate = LocalDate.now();
        Optional<User> user = userRepository.findByEmail(userEmail);
        User you = user.get();

        log.info("db password = {}, input password= = {}", user.get().getPassword(), pw);
        if (user.get().getPassword().equals(pw)){
            return "Success";
        }
        return "Failed";
    }
    //email로 조회


}
