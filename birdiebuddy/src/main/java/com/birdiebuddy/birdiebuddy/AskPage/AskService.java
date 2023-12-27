//package com.birdiebuddy.birdiebuddy.AskPage;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RequiredArgsConstructor
//@Service
//public class AskService {
//
//    private final AskRepository askRepository;
//
//    @Transactional
//    public Long save(AskDTO askDTO)
//    {
//        return askRepository.save(askDTO.toEntity()).getPostId();
//    }
//
//    @Transactional
//    public List<AskDTO> findByUser(Long user)
//    {
//        List<Ask> entities = askRepository.findAll()
//                .stream().filter(ask->ask.getUserKey()
//                        .equals(user)).collect(Collectors.toList());
//
//        List<AskDTO> asks = new ArrayList<>();
//
//        for (Ask ask : entities)
//            asks.add(new AskDTO(ask));
//
//        return asks;
//    }
//
//    @Transactional
//    public List<AskDTO> findByTitle(String word)
//    {
//        List<Ask> entities = askRepository.findAll()
//                .stream().filter(ask -> ask.getTitle()
//                        .contains(word)).collect(Collectors.toList());
//
//        List<AskDTO> asks = new ArrayList<>();
//
//        for (Ask ask : entities)
//            asks.add(new AskDTO(ask));
//
//        return asks;
//    }
//
//    @Transactional
//    public Long update(Long id, AskDTO askDTO)
//    {
//        Ask ask = askRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("객체를 찾을 수 없습니다." + id));
//
//        ask.update(askDTO.getTitle(), askDTO.getContent());
//
//        return ask.getPostId();
//    }
//}
