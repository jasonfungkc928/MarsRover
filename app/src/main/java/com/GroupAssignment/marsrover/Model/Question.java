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
        String[] answers1 = new String[3];
        ArrayList<Question> qListToReturn = new ArrayList();

        answers1[0] = "a) “Hello World”"; answers1[1] = "b) hello world!"; answers1[2] = "c) “System.out.print(hello world);”";
        qListToReturn.add(new Question("1. The Print statement","What would be the output of this program?",answers1[1], answers1, R.drawable.question1));

        String[] answers2 = new String[3];
        answers2[0] = "a) “output”"; answers2[1] = "b) “print me out”"; answers2[2] = "c) No output (error)";
        qListToReturn.add(new Question("2. Assigning values to variables","What would be the output of this program?",answers2[1], answers2, R.drawable.question2));

        String[] answers3 = new String[3];
        answers3[0] = "a) a = 4; b = 3"; answers3[1] = "b) a = 7; b = 7"; answers3[2] = "c) a = “four”;  b = “three”";
        qListToReturn.add(new Question("3. Concatenation","What do the variables a & b need to be for the output to be “4 + 3 = 7”?",answers3[0], answers3, R.drawable.question3));

        String[] answers4 = new String[3];
        answers4[0] = "a) a = 53; b = 82"; answers4[1] = "b) a = 7; b = 5"; answers4[2] = "c) a = 3; b = 3";
        qListToReturn.add(new Question("1. The if statement","What values will cause this program to print something out to the terminal?",answers4[1], answers4, R.drawable.question4));

        String[] answers5 = new String[3];
        answers5[0] = "a) a = 9; b = 5"; answers5[1] = "b) this program always prints that out"; answers5[2] = "c) a = 0; b = 0";
        qListToReturn.add(new Question("2. The else statement","What values will make this program print “a is not greater than b”?",answers5[2], answers5, R.drawable.question5));

        String[] answers6 = new String[3];
        answers6[0] = "a) Nothing, it should work"; answers6[1] = "b) &"; answers6[2] = "c) &&";
        qListToReturn.add(new Question("3. Operators","To make this program work, what would we need to put instead of ‘AND’?",answers6[2], answers6, R.drawable.question6));

        String[] answers7 = new String[3];
        answers7[0] = "a) 5"; answers7[1] = "b) 1"; answers7[2] = "c) 3";
        qListToReturn.add(new Question("1. The while loop","How many times will the following print out the phrase “hello”?",answers7[2], answers7, R.drawable.question7));

        String[] answers8 = new String[3];
        answers8[0] = "a) i will never reach 3, it’s an infinite loop"; answers8[1] = "b) i-- is not proper syntax"; answers8[2] = "c) //do something is missing a ;";
        qListToReturn.add(new Question("2. The while mistake","What is the error in the following code?",answers8[0], answers8, R.drawable.question8));

        String[] answers9 = new String[3];
        answers9[0] = "a) 0,1,2,3,4,5"; answers9[1] = "b) “i” 5 times"; answers9[2] = "c) “i” 6 times";
        qListToReturn.add(new Question("3. The for loop","What would be the output of this program?",answers9[2], answers9, R.drawable.question9));

        String[] answers10 = new String[3];
        answers10[0] = "a) The method sum is missing a return statement"; answers10[1] = "b) The sum isn’t printed out"; answers10[2] = "c) You can’t call methods from the main method";
        qListToReturn.add(new Question("1. The sum method","The following code does not seem to compile, find out why",answers10[0], answers10, R.drawable.question10));

        String[] answers11 = new String[3];
        answers11[0] = "a) Trick question! The program won't actually run"; answers11[1] = "b) Method overloading, the program knows which one to run based on the order they’re called"; answers11[2] = "c) Method overloading, the program knows which one to run based on input parameters";
        qListToReturn.add(new Question("2. Method overloading"," ",answers11[2], answers11, R.drawable.question11));

        String[] answers12 = new String[3];
        answers12[0] = "a) Static class can only be accessed by a getter or setter"; answers12[1] = "b) Class variables in OO programming  are Private or Protected, so getters and setters are the only way to access those class variables"; answers12[2] = "c) Class variables can NOT be edited unless getters and setters have been created";
        qListToReturn.add(new Question("3. Getters and Setters","Which of the following is the most valid reason for using getters and setters in an object-oriented program design?",answers12[1], answers12, 0));

        return qListToReturn;
    }
}
