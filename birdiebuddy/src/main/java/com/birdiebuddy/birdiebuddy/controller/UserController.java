package com.birdiebuddy.birdiebuddy.controller;

import com.birdiebuddy.birdiebuddy.dto.UserDto;
import com.birdiebuddy.birdiebuddy.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor //private final 쓸 때 붙이기
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/SignInPage")
    public long signUp(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    //조회
    @GetMapping("/api/user/find/{id}")
    public UserDto findById(@PathVariable long id){
        return userService.findById(id);
    }

    //프사 업데이트
    @GetMapping("/api/user/update/{id}")
    public Long update(@PathVariable Long id, UserDto userDto){
        return userService.update(id, userDto);
    }

    //로그인
    @GetMapping("/StartPage")
    public ResponseEntity login(@RequestBody UserDto userDto){
        log.info("userId = {}, password = {}", userDto.toEntity().getUserId(), userDto.toEntity().getPw());
        if (userService.login(userDto.toEntity().getUserId(), userDto.toEntity().getPw()).equals("Success")){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


}
