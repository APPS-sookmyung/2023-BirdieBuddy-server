package com.birdiebuddy.birdiebuddy.user.dto;

import com.birdiebuddy.birdiebuddy.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    // id, email(name), pw, image를 가짐.
    private String userId;
    private String email;
    private String pw;
    private String image;

//    @Builder
//    public UserDto(String userId, String email, String pw, String img){
//        this.userId = userId;
//        this.email = email;
//        this.pw = pw;
//        this.image = img;
//    }
//
    @Builder
    public UserDto(User user){
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.pw = user.getPw();
        this.image = user.getImage();
    } //Usercontroller - signUp을 위해서 작성.
    //Userservice - findbyId 위해 작성.


    public User toEntity(){
        return User.builder()
                .userId(userId)
                .email(email)
                .pw(pw)
                .image(image)
                .build();
    } //Userservice - save를 위해 작성.

    public void update(String img){
        this.image = img;
    }

}
