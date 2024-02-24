package com.birdiebuddy.birdiebuddy.bird.controller;

import com.birdiebuddy.birdiebuddy.bird.service.BirdService;
import com.birdiebuddy.birdiebuddy.bird.entity.Bird;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BirdController {
    private final BirdService birdService;

    @GetMapping("/api/encyclopedia")
    public Result list(){
        List<Bird> birds=birdService.findBirds();
        List<BirdDto> collect=birds.stream()
                .map(m->new BirdDto(m.getId(),m.getName(),m.getScien_name(),m.getImage(),m.getContent()))
                .collect(Collectors.toList());
        return new Result(collect);
    }

    @GetMapping("/api/bird/{bird_id}")
    public Result birdpage(@PathVariable("bird_id") Long bird_id){
        Optional<Bird> bird=birdService.findBird(bird_id);

        return new Result(bird);
    }

    @GetMapping("/api/pictureEncyclopedia")
    public Result picList(){
        List<Bird> birds=birdService.findBirds();

        List<PicBirdDto> collect=birds.stream()
                .map(m->new PicBirdDto(
                        m.getId(),
                        m.getName(),
                        m.getScien_name(),
                        m.getImage(),
                        m.getContent(),
                        Collections.singletonList(m.getSize_tag()),
                        m.getHabitats().stream()
                                .map(habitatDto -> habitatDto.getHabitat())
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());

        return new Result(collect);
    }

    //검색 api
    @GetMapping("/search")
    public Result search(){
        return null;
    }

    @GetMapping("/api/familyEncyclopedia")
    public Result familiyList(){
        List<Bird> birds=birdService.findBirds();

        Set<String> collect = birds.stream()
                .map(m -> m.getClassed())
                .collect(Collectors.toSet());

        return new Result(collect);
    }

    @GetMapping("/api/familyEncyclopedia/{family}")
    public Result family(@PathVariable("family")String classed){
        List<Bird> birds=birdService.findByClass(classed);

        List<familySearchDto> collect=birds.stream()
                .map(m->new familySearchDto(m.getId(),m.getName(),
                        m.getScien_name(),m.getContent(),m.getImage(),classed))
                .collect(Collectors.toList());
        return new Result(collect);
    }


    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class BirdDto{
        Long id;
        String name;
        String sci_name;
        String image;
        String content;
    }

    @Data
    @AllArgsConstructor
    static class PicBirdDto{
        Long id;
        String name;
        String sci_name;
        String image;
        String content;
        List<Integer> size_tag;
        List<Integer> habitats;
    }

    @Data
    @AllArgsConstructor
    static class HabitatDto {
        Long id;
        int habitat;
    }

    @Data
    @AllArgsConstructor
    static class familyDto{
        String classed;
    }

    @Data
    @AllArgsConstructor
    static class familySearchDto{
        Long id;
        String name;
        String sci_name;
        String image;
        String content;
        String classed;
    }
}
