package com.GroupAssignment.marsrover;


import java.util.ArrayList;

public class Lessons {
    private String lesson;
    private String def1;
    private String def2;

    public Lessons(){}

    public Lessons(String lesson, String def1, String def2) {
        this.lesson = lesson;
        this.def1 = def1;
        this.def2 = def2;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1;
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2;
    }

    public static ArrayList<Lessons> lessonsList(){
    ArrayList<Lessons> lessons = new ArrayList<>();
    lessons.add(new Lessons("Print Statement",
            "The print( ) and println( ) methods vary in the manner that, when using println( ), in the output screen the cursor will be shown on the next line after printing the required output on the screen.",
            "Basically we can understand 'ln' in 'println' as the 'next line'."));
    lessons.add(new Lessons("If Statement",
            "The Java if statement is used to test the condition. It checks boolean condition: true or false. There are various types of if statement in Java (if statement, if-else statement, if-else-if ladder, nested if statement",
            "if(condition) {//code to be executed}"));
    lessons.add(new Lessons("While Loop",
            "The Java while loop is used to iterate a part of the program several times. If the number of iteration is not fixed, it is recommended to use while loop. If you pass true in the while loop, it will be infinitive while loop.",
            "while(condition) {//code to be executed}"));
    lessons.add(new Lessons("For Loop",
            "The Java for loop is a control flow statement that iterates a part of the programs multiple times. If the number of iteration is fixed, it is recommended to use for loop.",
            "for(condition) {//code to be executed }"));
    lessons.add(new Lessons("Oject Oriented Programming",
            "Object means a real - world entity such as a pen, chair, table, computer, watch, etc.Object - Oriented Programming is a methodology or paradigm to design a program using classes and objects.It simplifies software development and maintenance by providing some concepts:",
            "Class, Object, Inheritance, Polymorphism, Abstraction, Encapsulation"));
    return lessons;
    }

    public Lessons searchLesson(String lesson) {
        Lessons searchedL = new Lessons();
        ArrayList<Lessons> lessons = Lessons.lessonsList();
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getLesson().equals(lesson)) {
                return lessons.get(i);
            }
        }
        return  null;
    }
}
