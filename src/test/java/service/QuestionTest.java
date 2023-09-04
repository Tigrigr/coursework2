package service;

import sky.pro.coursework2.data.Question;

import java.util.Collection;
import java.util.Set;

public class QuestionTest {
    public static final Question QUESTION_1 = new Question("Question1", "Answer1");
    public static final Question QUESTION_2 = new Question("Question2", "Answer2");
    public static final Question QUESTION_3 = new Question("Question3", "Answer3");
    public static final Question QUESTION_4 = new Question("Question4", "Answer4");
    public static final Question QUESTION_5 = new Question("Question5", "Answer5");

    public static final Collection<Question> QUESTIONS = Set.of(
            QUESTION_1,
            QUESTION_2,
            QUESTION_3,
            QUESTION_4,
            QUESTION_5
    );
}
