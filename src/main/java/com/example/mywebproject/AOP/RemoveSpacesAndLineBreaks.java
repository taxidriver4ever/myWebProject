package com.example.mywebproject.AOP;

import com.example.mywebproject.Mapper.XiGaiMapper;
import com.example.mywebproject.Pojo.choiceQuestion;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RemoveSpacesAndLineBreaks {

    @Around("@annotation(com.example.mywebproject.anno.RemoveSpaces)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        choiceQuestion question = (choiceQuestion)joinPoint.getArgs()[0];
        question.setQuestion(getNewString(question.getQuestion()));
        question.setSelectionA(getNewString(question.getSelectionA()));
        question.setSelectionB(getNewString(question.getSelectionB()));
        question.setSelectionC(getNewString(question.getSelectionC()));
        question.setSelectionD(getNewString(question.getSelectionD()));
        question.setAnswer(getNewString(question.getAnswer()));
        question.setExplanation(getNewString(question.getExplanation()));
        Object proceed = joinPoint.proceed();
        return proceed;
    }

    public String getNewString(String OldString) {
        String tmp = "";
        for ( Character c : OldString.toCharArray() ) {
            if(c.equals(' ') || c.equals('\n')) continue;
            else tmp += c;
        }
        return tmp;
    }

}
