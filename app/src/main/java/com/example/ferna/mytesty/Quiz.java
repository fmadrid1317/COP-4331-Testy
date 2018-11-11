package com.example.ferna.mytesty;

import java.io.Serializable;


//Doubly Linked List Nonsense
//0 is Multiple Choice, 1 is True False, 2 is Free Response
public class Quiz implements Serializable
{
    Question head;
    Question current;
    int questionCount;

    Quiz()
    {
        Question head = null;
        Question current = null;
        questionCount = 0;
    }

    void addQuest(int questType, String qQuestion, String corAns, String wroAns1, String wroAns2, String wroAns3, Boolean tF)
    {
        Question newQuest = new Question(questType, qQuestion, corAns, wroAns1, wroAns2, wroAns3, tF);
        newQuest.next = head;
        newQuest.previous = null;
        if (head != null)
            head.previous = newQuest;

        head = newQuest;
    }

    void nextQuestion()
    {
        if(current == null)
            current = head;
        else if(current.next == null)
            ;
        else
            current = current.next;
    }

    void previousQuestion()
    {
        if(current == null)
            current = head;
        else if(current.previous == null)
            ;
        else
            current = current.previous;
    }

    class Question implements Serializable
    {
        private int quesType;
        private String quizQuestion;
        private String corrAns;
        private String wrongAns1;
        private String wrongAns2;
        private String wrongAns3;
        private Boolean truFal;
        Question previous, next;

        Question(int questType, String qQuestion, String corAns, String wroAns1, String wroAns2, String wroAns3, Boolean tF)
        {
            setQuesType(questType);
            setQuizQuestion(qQuestion);
            setCorrAns(corAns);
            setWrongAns1(wroAns1);
            setWrongAns2(wroAns2);
            setWrongAns3(wroAns3);
            setTruFal(tF);
            previous = null;
            next = null;
        }

        //Copies i's data to j
        void questDupe(Question i, Question j)
        {
            j.setQuesType(i.getQuesType());
            j.setQuizQuestion(i.getQuizQuestion());
            j.setCorrAns(i.getCorrAns());
            j.setWrongAns1(i.getWrongAns1());
            j.setWrongAns2(i.getWrongAns2());
            j.setWrongAns3(i.getWrongAns3());
            j.setTruFal(i.getTruFal());
        }


        public String getQuizQuestion() {
            return quizQuestion;
        }

        public void setQuizQuestion(String quizQuestion) {
            this.quizQuestion = quizQuestion;
        }

        public int getQuesType() {
            return quesType;
        }

        public void setQuesType(int quesType) {
            this.quesType = quesType;
        }

        public String getCorrAns() {
            return corrAns;
        }

        public void setCorrAns(String corrAns) {
            this.corrAns = corrAns;
        }

        public String getWrongAns1() {
            return wrongAns1;
        }

        public void setWrongAns1(String wrongAns1) {
            this.wrongAns1 = wrongAns1;
        }

        public String getWrongAns2() {
            return wrongAns2;
        }

        public void setWrongAns2(String wrongAns2) {
            this.wrongAns2 = wrongAns2;
        }

        public String getWrongAns3() {
            return wrongAns3;
        }

        public void setWrongAns3(String wrongAns3) {
            this.wrongAns3 = wrongAns3;
        }

        public Boolean getTruFal() {
            return truFal;
        }

        public void setTruFal(Boolean truFal) {
            this.truFal = truFal;
        }
    }


}
