package service;

import exception.QuestionAmountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static service.QuestionTest.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Test
    void getQuestions() {
        when(questionService.gelAll()).thenReturn(QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(
                QUESTION_1,
                QUESTION_2,
                QUESTION_3,
                QUESTION_4,
                QUESTION_5
        );
        assertThat(examinerService.getQuestions(QUESTIONS.size() - 1))
                .hasSize(QUESTIONS.size() - 1);
    }

    @Test
    void getQuestionsThrow() {
        when(questionService.gelAll()).thenReturn(QUESTIONS);

        assertThatExceptionOfType(QuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
        assertThatExceptionOfType(QuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(QUESTIONS.size() + 1));
    }
}