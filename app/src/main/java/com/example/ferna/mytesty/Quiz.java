package com.example.ferna.mytesty;

import android.util.Log;
import android.widget.EditText;

import java.io.Serializable;


//Doubly Linked List Nonsense
//0 is Multiple Choice, 1 is True False, 2 is Free Response
public class Quiz implements Serializable
{
    Question head;

    Quiz()
    {
        Question head = null;
    }

    void addQuest(int questType, EditText qQuestion, EditText corAns, EditText wroAns1, EditText wroAns2, EditText wroAns3, Boolean tF)
    {
        Question newQuest = new Question(questType, qQuestion, corAns, wroAns1, wroAns2, wroAns3, tF);
        newQuest.next = head;
        newQuest.previous = null;
        if(newQuest.next == null)
            Log.d("aaa", "AAAAAAAAAA");
        if (head != null)
            head.previous = newQuest;

        head = newQuest;
    }

    class Question implements Serializable
    {
        int quesType;
        EditText quizQuestion;
        EditText corrAns;
        EditText wrongAns1;
        EditText wrongAns2;
        EditText wrongAns3;
        Boolean truFal;
        Question previous, next;

        Question(int questType, EditText qQuestion, EditText corAns, EditText wroAns1, EditText wroAns2, EditText wroAns3, Boolean tF)
        {
            quesType = questType;
            quizQuestion = qQuestion;
            corrAns = corAns;
            wrongAns1 = wroAns1;
            wrongAns2 = wroAns2;
            wrongAns3 = wroAns3;
            truFal = tF;
            previous = null;
            next = null;
        }

        //Copies i's data to j
        void questDupe(Question i, Question j)
        {
            j.quesType = i.quesType;
            j.quizQuestion = i.quizQuestion;
            j.corrAns = i.corrAns;
            j.wrongAns1 = i.wrongAns1;
            j.wrongAns2 = i.wrongAns2;
            j.wrongAns3 = i.wrongAns3;
            j.truFal = i.truFal;
        }

    }


}
