package com.birdiebuddy.birdiebuddy.AskPage.Service;

import com.birdiebuddy.birdiebuddy.AskPage.DTO.AnswerDTO;
import com.birdiebuddy.birdiebuddy.AskPage.Entity.AnswerToAsk;
import com.birdiebuddy.birdiebuddy.AskPage.Repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Transactional
    public Long save(AnswerDTO answerDTO) {return answerRepository.save(answerDTO.ToEntity()).getAnswerId();}

    @Transactional
    public AnswerDTO findById(Long id)
    {
        AnswerToAsk answer = answerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found Answer: " + id));

        return new AnswerDTO(answer);
    }

    @Transactional
    public List<AnswerToAsk> findAnswerAsk(Long id)
    {
        List<AnswerToAsk> answers = answerRepository.findAll()
                .stream().filter(answer -> answer.getAskId()
                        .equals(id)).collect(Collectors.toList());

        return answers;
    }

    @Transactional
    public List<AnswerToAsk> findAnswerChild(Long parent)
    {
        List<AnswerToAsk> answers = answerRepository.findAll()
                .stream().filter(answer -> answer.getParentId()
                        .equals(parent)).collect(Collectors.toList());

        return answers;
    }
//
//    @Transactional
//    public Long update(Long id, AnswerDTO answerDTO)
//    {
//        AnswerToAsk answer = answerRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("객체를 찾을 수 없습니다." + id));
//
//        answer.update(answerDTO.getContent());
//
//        return answer.getAnswerId();
//    }
}
