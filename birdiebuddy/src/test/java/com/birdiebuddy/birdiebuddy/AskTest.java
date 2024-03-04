package com.birdiebuddy.birdiebuddy;

import com.birdiebuddy.birdiebuddy.AskPage.DTO.AnswerDTO;
import com.birdiebuddy.birdiebuddy.AskPage.DTO.AskDTO;
import com.birdiebuddy.birdiebuddy.AskPage.Entity.AnswerToAsk;
import com.birdiebuddy.birdiebuddy.AskPage.Entity.Ask;
import com.birdiebuddy.birdiebuddy.AskPage.Repository.AnswerRepository;
import com.birdiebuddy.birdiebuddy.AskPage.Repository.AskRepository;
import com.birdiebuddy.birdiebuddy.AskPage.Service.AnswerService;
import com.birdiebuddy.birdiebuddy.AskPage.Service.AskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@ContextConfiguration(classes = BirdiebuddyApplication.class)

public class AskTest {
    @Autowired
    AskService askService;
    @Autowired
    AskRepository askRepository;
    @Autowired
    AnswerService answerService;
    @Autowired
    AnswerRepository answerRepository;

    @Test
    public void MakeAsk()
    {
        //저장
        Ask ask = new Ask(1l, 10l, "하하하하하", "이게 제목이다", "03.04");
        Long id = askService.save(new AskDTO(ask));
        assertEquals(1, id, "저장 후 id 반환값이 정상적이지 않아요");

        //조회 - 게시글 id 조회
        AskDTO askFromId = askService.findById(1l);
        assertEquals("이게 제목이다", askFromId.getTitle(), "제목이 일치하지 않습니다: " + askFromId.getTitle());
        assertEquals("하하하하하", askFromId.getContent(), "내용이 일치하지 않습니다: " + askFromId.getContent());

        //조회 - 게시글 제목 조회
        Ask ask2 = new Ask(2l, 20l, "호호호호호", "이게 사실이다", "03.05");
        askService.save(new AskDTO(ask2));
        Ask ask3 = new Ask(3l, 30l, "호호호호", "이게", "03.06");
        askService.save(new AskDTO(ask3));
        Ask ask4 = new Ask(3l, 30l, "호호호호", "사실이다", "03.06");
        askService.save(new AskDTO(ask4));
        List<AskDTO> askFromTitle = askService.findByTitle("이게");

        String test = "";
        for (AskDTO d:askFromTitle) {
            test += d.getAskId().toString();
        }

        assertEquals("123", test, "타이틀 검색 결과가 일치하지 않습니다: " + test);

        //조회 - 특정 유저의 게시글 조회
        List<AskDTO> askFromUser = askService.findByUser(3l);

        assertEquals(2, askFromUser.size(), "유저를 통한 게시글 검색 결과 개수가 일치하지 않아요: " + askFromUser.size());
        assertEquals("이게", askFromUser.get(0).getTitle(), "유저를 통한 게시글 검색 결과가 일치하지 않습니다: " + askFromUser.get(0).getTitle());
        assertEquals("사실이다", askFromUser.get(1).getTitle(), "유저를 통한 게시글 검색 결과가 일치하지 않습니다: " + askFromUser.get(1).getTitle());
    }

    @Test
    public void MakeAnswer()
    {
        //저장
        Ask ask = new Ask(1l, 10l, "하하하하하", "이게 제목이다", "03.04");
        Long askid = askService.save(new AskDTO(ask));

        AnswerToAsk answer = new AnswerToAsk(100l, 1l, "03.07", "이게 댓글이다", false, 0l, 20l);
        Long id = answerService.save(new AnswerDTO(answer));

        assertEquals(100l, id, "id가 이상하다고 생각하지 않니: " + id);

        //조회 - 게시글로 조회
        AnswerToAsk answer2 = new AnswerToAsk(200l, 1l, "03.08", "이게 댓글2다", false, 1l, 30l);
        AnswerToAsk answer3 = new AnswerToAsk(300l, 2l, "03.08", "이게 댓글32다", false, 1l, 10l);
        AnswerToAsk answer4 = new AnswerToAsk(400l, 2l, "03.08", "이게 대댓글이다", true, 300l, 20l);
        answerService.save(new AnswerDTO(answer2));
        answerService.save(new AnswerDTO(answer3));
        answerService.save(new AnswerDTO(answer4));

        List<AnswerToAsk> answers = answerService.findAnswerAsk(1l);

        assertEquals(100l, answers.get(0).getAnswerId(), "이 게시글의 첫 번째 댓글은 " + answers.get(0).getContent());
        assertEquals(200l, answers.get(1).getAnswerId(), "이 게시글의 두 번째 댓글은 " + answers.get(1).getContent());

        //조회 - 댓글로 조회(해당 댓글의 대댓글 목록)
        AnswerToAsk answer5 = new AnswerToAsk(500l, 2l, "03.08", "이게 대댓글2다", true, 300l, 10l);
        AnswerToAsk answer6 = new AnswerToAsk(600l, 1l, "03.08", "다른 게시글의 대댓글이다", true, 100l, 20l);
        AnswerToAsk answer7 = new AnswerToAsk(700l, 2l, "03.08", "다른 댓글의 대댓글이다", true, 400l, 30l);
        answerService.save(new AnswerDTO(answer5));
        answerService.save(new AnswerDTO(answer6));
        answerService.save(new AnswerDTO(answer7));

        List<AnswerToAsk> answerss = answerService.findAnswerChild(300l);

        int test = 0;
        for (AnswerToAsk a: answerss) {
            test += a.getAnswerId();
        }

        assertEquals(2, answerss.size(), "대댓글이 무려 " + answerss.size() + "개");
        assertEquals(900, test, "실제 대댓글 id 다 합친 값은 " + test);
    }
}
