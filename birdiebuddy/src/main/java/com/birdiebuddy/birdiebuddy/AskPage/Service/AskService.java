package com.birdiebuddy.birdiebuddy.AskPage.Service;

import com.birdiebuddy.birdiebuddy.AskPage.DTO.AskDTO;
import com.birdiebuddy.birdiebuddy.AskPage.Entity.Ask;
import com.birdiebuddy.birdiebuddy.AskPage.Repository.AskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AskService {

    private final AskRepository askRepository;

    @Transactional
    public Long save(AskDTO askDTO)
    {
        return askRepository.save(askDTO.toEntity()).getAskId();
    }

    public AskDTO findById(Long id)
    {
        Ask ask = askRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Not Found Ask:  " + id));

        return new AskDTO(ask);
    }

    @Transactional
    public List<AskDTO> findByUser(Long id)
    {
        List<Ask> ask = askRepository.findByUserKey(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found This Users Post " + id));

        List<AskDTO> askD = new ArrayList<AskDTO>();
        for (Ask a: ask){
            askD.add(new AskDTO(a));
        }

        return askD;
    }

    @Transactional
    public List<AskDTO> findByTitle(String title)
    {
        List<Ask> ask = askRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("Not Found Post " + title));

        List<AskDTO> askD = new ArrayList<AskDTO>();
        for (Ask a: ask) {
            askD.add(new AskDTO(a));
        }

        return askD;
    }
//    @Transactional
//    public Long update(Long id, AskDTO askDTO)
//    {
//        Ask ask = askRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("객체를 찾을 수 없습니다." + id));
//
//        ask.update(askDTO.getTitle(), askDTO.getContent());
//
//        return ask.getAskId();
//    }

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
}
