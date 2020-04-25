package com.GroupAssignment.marsrover.Model;

import com.GroupAssignment.marsrover.R;

import java.lang.reflect.Array;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Random;

public class Question {
    private String qTitle;
    private String  qText;
    private String correctAnswer;
    private String[] answers = new String[3];
    private int imgResource;

    public Question(){
        //blank constructor
    }

    public Question(String qTitle, String qText, String correctAnswer, String[] answers, int imgResource ){
        this.qTitle = qTitle;
        this.qText=qText;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
        this.imgResource = imgResource;
    }

    public String getqTitle() {
        return qTitle;
    }

    public String getqText() {
        return qText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getImgResource() {
        return imgResource;
    }

    public ArrayList<Question> createQuestions(){
        String[] answers = new String[3];
        ArrayList<Question> qListToReturn = new ArrayList();
        answers[0] = "a) “Hello World”"; answers[1] = "b) hello world!"; answers[2] = "c) “System.out.print(hello world);”";
        qListToReturn.add(new Question("1. The Print statement","What would be the output of this program?",answers[1], answers, R.drawable.question1));

        answers[0] = "a) “output”"; answers[1] = "b) “print me out”"; answers[2] = "c) No output (error)";
        qListToReturn.add(new Question("2. Assigning values to variables","What would be the output of this program?",answers[1], answers, R.drawable.question2));

        answers[0] = "a) a = 4; b = 3"; answers[1] = "b) a = 7; b = 7"; answers[2] = "c) a = “four”;  b = “three”";
        qListToReturn.add(new Question("3. Operators and Concatenation","What do the variables a & b need to be for the output to be “4 + 3 = 7”?",answers[0], answers, R.drawable.question3));



        return qListToReturn;
    }
}
