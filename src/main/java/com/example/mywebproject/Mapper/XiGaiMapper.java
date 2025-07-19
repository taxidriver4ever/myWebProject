package com.example.mywebproject.Mapper;

import com.example.mywebproject.Pojo.choiceQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XiGaiMapper {
    public List<choiceQuestion> selectAllQuestion();
    public Integer selectAllQuestionCount();
    public void addQuestion(choiceQuestion question);
    public List<choiceQuestion> selectQuestionByName(String question);
    public void deleteQuestionByName(String question);
    public void updateQuestion(choiceQuestion question);
    public Integer selectIdByName(String questionName);
}
