package com.birdiebuddy.birdiebuddy.user.controller;

import com.birdiebuddy.birdiebuddy.user.dto.UserDto;
import com.birdiebuddy.birdiebuddy.user.entity.User;
import com.birdiebuddy.birdiebuddy.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //private final 쓸 때 붙이기
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/api/user/signin")
    public long signUp(@RequestBody UserDto userDto){
        log.info("userId = {}, password = {}", userDto.toEntity().getUserId(), userDto.toEntity().getPw());
        log.info("email = {}, image = {}, id = {}", userDto.toEntity().getEmail(), userDto.toEntity().getImage(), userDto.toEntity().getId());
        return userService.save(userDto);
    }

    //조회
    @GetMapping("/api/user/find/{id}")
    public UserDto findById(@PathVariable("id") long id){
        return userService.findById(id);
    }

//    //프사 업데이트
//    @PostMapping("/api/user/update/{id}")
//    public Long update(@PathVariable("id") Long id, UserDto userDto){
//        return userService.update(id, userDto);
//    }

    //로그인
    @PostMapping("/api/user/login")
    public ResponseEntity login(@RequestBody UserDto userDto){
        log.info("userId = {}, password = {}", userDto.toEntity().getUserId(), userDto.toEntity().getPw());
        log.info("email = {}, image = {}", userDto.toEntity().getEmail(), userDto.toEntity().getImage());
        if (userService.login(userDto.toEntity().getEmail(), userDto.toEntity().getPw()).equals("Success")){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Data
    @AllArgsConstructor
    static class  Result<T>{
        private T data;
    }

    @GetMapping("/api/user/allusers")
    public Result list(){
        List<User> users=userService.findAll();
        List<UserDto> collect = users.stream()
                .map(m->new UserDto(m.getUserId(),m.getEmail(),m.getPw(),m.getImage()))
                .collect(Collectors.toList());
        return new Result(collect);
    }


}
