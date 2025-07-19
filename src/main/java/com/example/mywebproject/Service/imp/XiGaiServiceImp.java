package com.example.mywebproject.Service.imp;

import com.example.mywebproject.Mapper.XiGaiMapper;
import com.example.mywebproject.Pojo.choiceQuestion;
import com.example.mywebproject.Service.XiGaiService;
import com.example.mywebproject.anno.RemoveSpaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class XiGaiServiceImp implements XiGaiService {

    @Autowired
    private XiGaiMapper xiGaiMapper;

    @Override
    public List<choiceQuestion> selectAllQuestion() {
        return xiGaiMapper.selectAllQuestion();
    }

    @Override
    public Integer selectAllQuestionCount() {
        return xiGaiMapper.selectAllQuestionCount();
    }

    @RemoveSpaces
    @Transactional
    @Override
    public void addQuestion(choiceQuestion question) {
        xiGaiMapper.addQuestion(question);
    }

    @Override
    public List<choiceQuestion> selectQuestionByName(String question) {
        return xiGaiMapper.selectQuestionByName(question);
    }

    @Transactional
    @Override
    public void deleteQuestion(choiceQuestion question) {
        xiGaiMapper.deleteQuestionByName(question.getQuestion());
    }

    @RemoveSpaces
    @Transactional
    @Override
    public void updateQuestion(choiceQuestion question) {
        xiGaiMapper.updateQuestion(question);
    }

    @Override
    public Integer selectIdByName(String questionName) {
        return xiGaiMapper.selectIdByName(questionName);
    }
}
