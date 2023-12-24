package com.birdiebuddy.birdiebuddy;
import com.birdiebuddy.birdiebuddy.AskPage.Ask;
import com.birdiebuddy.birdiebuddy.AskPage.AskDTO;
import com.birdiebuddy.birdiebuddy.AskPage.AskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@ContextConfiguration(classes = BirdiebuddyApplication.class)
public class AskTest {

    @Autowired
    private AskService askService;

    @Test
    void findByUserTest()
    {
        List<Long> comment = List.of();
        Ask ask1 = new Ask(1l, 1l, "제목1", "내용1", "23.12.20", comment);
        Ask ask2 = new Ask(2l, 2l, "제목2", "내용2", "23.12.21", comment);
        Ask ask3 = new Ask(3l, 3l, "제목3", "내용3", "23.12.21", comment);
        Ask ask4 = new Ask(4l, 2l, "제목4", "내용4", "23.12.21", comment);

        assertThat(askService).isEqualTo(null);

        askService.save(new AskDTO(ask1));
        askService.save(new AskDTO(ask2));
        askService.save(new AskDTO(ask3));
        askService.save(new AskDTO(ask4));

//        List<AskDTO> dt = askService.findByUser(2l);
//
//        assertThat(dt.size()).isEqualTo(2);
//        assertThat(dt.get(0).getPostId()).isEqualTo(2l);
//        assertThat(dt.get(1).getPostId()).isEqualTo(4l);
    }

}
