package com.example.ferna.mytesty;

import android.widget.EditText;


//Doubly Linked List Nonsense
public class Quiz
{
    Question head;
    Question current;

    Quiz()
    {
        head = new Question(0);
        current = head;
    }

    void addQuest(int questType)
    {
        Question newQuest = new Question(questType);
        current.next = newQuest;
        newQuest.previous = current;
        current = newQuest;
    }

    void toHead()
    {
        current = head;
    }

    class Question
    {
        int quesType;
        EditText quizQuestion;
        EditText corrAns;
        EditText wrongAns1;
        EditText wrongAns2;
        EditText wrongAns3;
        Boolean truFal;
        Question previous, next;

        Question(int questType)
        {
            quesType = questType;
            quizQuestion = null;
            corrAns = null;
            wrongAns1 = null;
            wrongAns2 = null;
            wrongAns3 = null;
            truFal = null;
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
