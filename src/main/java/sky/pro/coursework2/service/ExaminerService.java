package sky.pro.coursework2.service;

import sky.pro.coursework2.data.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
