package com.example.mywebproject.Controller;

import com.example.mywebproject.Pojo.choiceQuestion;
import com.example.mywebproject.Pojo.myResult;
import com.example.mywebproject.Service.XiGaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class XiGaiController {

    @Autowired
    private XiGaiService xiGaiService;

    @GetMapping("/getXiGai")
    public myResult selectAllXiGai() {
        return myResult.success(xiGaiService.selectAllQuestion());
    }

    @PostMapping("/addXiGai")
    public myResult addXiGai(@RequestBody choiceQuestion choicequestion) {
        if(xiGaiService.selectIdByName(choicequestion.getQuestion()) == null) {
            xiGaiService.addQuestion(choicequestion);
            return myResult.success(null);
        }
        return myResult.error("该问题已经添加过");
    }

    @PostMapping("/selectByProblemName")
    public myResult selectByProblemName(@RequestBody choiceQuestion choicequestion) {
        String question = choicequestion.getQuestion();
        List<choiceQuestion> choiceQuestions = xiGaiService.selectQuestionByName(question);
        return myResult.success(choiceQuestions);
    }

    @PostMapping("/deleteByProblemName")
    public myResult deleteByProblemName(@RequestBody choiceQuestion choicequestion) {
        xiGaiService.deleteQuestion(choicequestion);
        return myResult.success(null);
    }

    @PostMapping("/updateXiGai")
    public myResult updateXiGai(@RequestBody choiceQuestion choicequestion) {
        choicequestion.setId(xiGaiService.selectIdByName(choicequestion.getQuestion()));
        xiGaiService.updateQuestion(choicequestion);
        return myResult.success(null);
    }

}
