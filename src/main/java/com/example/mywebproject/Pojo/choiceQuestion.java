package com.example.mywebproject.Pojo;

public class choiceQuestion {
    private Integer id;
    private String question;
    private String selectionA;
    private String selectionB;
    private String selectionC;
    private String selectionD;
    private String answer;
    private String explanation;

    public choiceQuestion() {
    }

    public choiceQuestion(Integer id, String question, String selectionA, String selectionB, String selectionC, String selectionD, Integer questionNum, String answer, String explanation) {
        this.id = id;
        this.question = question;
        this.selectionA = selectionA;
        this.selectionB = selectionB;
        this.selectionC = selectionC;
        this.selectionD = selectionD;
        this.answer = answer;
        this.explanation = explanation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSelectionA() {
        return selectionA;
    }

    public void setSelectionA(String selectionA) {
        this.selectionA = selectionA;
    }

    public String getSelectionB() {
        return selectionB;
    }

    public void setSelectionB(String selectionB) {
        this.selectionB = selectionB;
    }

    public String getSelectionC() {
        return selectionC;
    }

    public void setSelectionC(String selectionC) {
        this.selectionC = selectionC;
    }

    public String getSelectionD() {
        return selectionD;
    }

    public void setSelectionD(String selectionD) {
        this.selectionD = selectionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "choiceQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", selectionA='" + selectionA + '\'' +
                ", selectionB='" + selectionB + '\'' +
                ", selectionC='" + selectionC + '\'' +
                ", selectionD='" + selectionD + '\'' +
                ", answer='" + answer + '\'' +
                ", explanation='" + explanation + '\'' +
                '}';
    }
}
