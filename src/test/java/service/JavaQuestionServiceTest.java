package service;

import sky.pro.coursework2.exception.QuestionNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.coursework2.service.JavaQuestionService;
import sky.pro.coursework2.service.QuestionService;


import static service.QuestionTest.*;
import static org.assertj.core.api.Assertions.*;

class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        questionService.add(QUESTION_3);
    }

    @Test
    public void addQuestion() {
        int beforeCount = questionService.gelAll().size();

        assertThat(questionService.add(QUESTION_4)).isEqualTo(QUESTION_4).isIn(questionService.gelAll());

        assertThat(questionService.gelAll()).hasSize(beforeCount + 1);
    }


    @Test
    void removeQuestion() {
        int beforeCount = questionService.gelAll().size();

        assertThat(questionService.remove(QUESTION_3)).isEqualTo(QUESTION_3).isNotIn(questionService.gelAll());

        assertThat(questionService.gelAll()).hasSize(beforeCount - 1);

    }

    @Test
    public void removeQuestionThrow() {
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.remove(QUESTION_4));
    }

    @Test
    void gelAllQuestion() {
        assertThat(questionService.gelAll()).hasSize(3)
                .containsExactlyInAnyOrder(
                        QUESTION_1,
                        QUESTION_2,
                        QUESTION_3
                );
    }

    @Test
    void getRandomQuestion() {
        assertThat(questionService.getRandomQuestion()).isNotNull()
                .isIn(questionService.gelAll());
    }
}