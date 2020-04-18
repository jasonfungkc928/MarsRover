package com.GroupAssignment.marsrover.Model;

import java.util.ArrayList;
import java.util.Random;

public class Question {

    private int pressCounter = 0;
    private int maxPressCounter;
    private String keys;
    private String answer;

    public Question(int maxPressCounter, String answer, String keys) {
        this.pressCounter = 0;
        this.maxPressCounter = maxPressCounter;
        this.answer = answer;
        this.keys = keys;
    }

    public int getPressCounter() {
        return pressCounter;
    }

    public int getMaxPressCounter() {
        return maxPressCounter;
    }

    public String getKeys() {
        return keys;
    }

    public String getAnswer() {
        return answer;
    }

    public static ArrayList<Question> generateQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question(3,"int","ixnct"));

        return questions;
    }

}
