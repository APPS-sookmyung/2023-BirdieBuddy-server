package com.birdiebuddy.birdiebuddy.bird.dto;

import com.birdiebuddy.birdiebuddy.bird.entity.Bird;

public class BirdDto {
    private String name;
    private String sci_name;
    private String content;
    private int habitat; //서식지
    private int size; //사이즈
    private String classed; //분류 (과)

    public static Bird toEntity(){
        //Bird bird=Bird.builder()
        return null;
    }

//    @Builder
//    public static BirdDto
}
