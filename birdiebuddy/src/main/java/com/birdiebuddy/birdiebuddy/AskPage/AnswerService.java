package com.birdiebuddy.birdiebuddy.AskPage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnswerService {

    @Transactional
    AnswerToAsk findById(Long id)
    {
        return null;
    }

    @Transactional
    List<AnswerToAsk> findMyAnswer(Long commentId)
    {
        return null;
    }

    @Transactional
    AnswerToAsk update(Long commentId)
    {
        return null;
    }

}
