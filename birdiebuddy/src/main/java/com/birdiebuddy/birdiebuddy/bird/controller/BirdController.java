package com.birdiebuddy.birdiebuddy.bird.controller;

import com.birdiebuddy.birdiebuddy.bird.service.BirdService;
import com.birdiebuddy.birdiebuddy.bird.entity.Bird;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BirdController {
    private final BirdService birdService;

    @GetMapping("/EncyclopediaPage")
    public Result list(){
        List<Bird> birds=birdService.findBirds();
        List<BirdDto> collect=birds.stream()
                .map(m->new BirdDto(m.getName(),m.getScien_name(),m.getImage(),m.getContent()))
                .collect(Collectors.toList());
        return new Result(collect);
    }

    @GetMapping("/BirdPage/{int:bird_id}")
    public Result birdpage(){

        return null; 
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class BirdDto{
        String name;
        String sci_name;
        String image;
        String content;
    }
}
