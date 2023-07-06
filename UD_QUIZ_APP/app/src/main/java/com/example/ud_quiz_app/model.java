package com.example.ud_quiz_app;

public class model {
    String Question , Answer , oa ,ob , oc , od ;

    public model(String question , String Answer , String oa , String ob , String oc , String od) {
        this.Question = question;
        this.Answer = Answer;
        this.oa=oa;
        this.ob=ob;
        this.oc=oc;
        this.od=od;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getOa() {
        return oa;
    }

    public void setOa(String oa) {
        this.oa = oa;
    }

    public String getOb() {
        return ob;
    }

    public void setOb(String ob) {
        this.ob = ob;
    }

    public String getOc() {
        return oc;
    }

    public void setOc(String oc) {
        this.oc = oc;
    }

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }
}
