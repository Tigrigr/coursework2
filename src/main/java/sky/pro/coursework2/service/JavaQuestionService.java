package sky.pro.coursework2.service;

import sky.pro.coursework2.data.Question;
import sky.pro.coursework2.exception.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundException();
        }
        return question;
    }

    @Override
    public Collection<Question> gelAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Question[] arrQuest = questions.toArray(new Question[0]);
        Random random = new Random();
        int randomIndex = random.nextInt(arrQuest.length);
        return arrQuest[randomIndex];
    }
}
