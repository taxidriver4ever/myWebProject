package com.example.mywebproject.Service;

import com.example.mywebproject.Pojo.choiceQuestion;

import java.util.List;

public interface XiGaiService {
    public List<choiceQuestion> selectAllQuestion();
    public Integer selectAllQuestionCount();
    public void addQuestion(choiceQuestion question);
    public List<choiceQuestion> selectQuestionByName(String question);
    public void deleteQuestion(choiceQuestion question);
    public void updateQuestion(choiceQuestion question);
    public Integer selectIdByName(String questionName);
}
