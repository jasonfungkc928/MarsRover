package com.GroupAssignment.marsrover;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileScreen extends AppCompatActivity {

    private TextView name, score, medal, lesson1, lesson2, lesson3, lesson4, lesson5, lesson6, lesson7, lesson8, lesson9;
    private ImageView profilepic, medal1, medal2, medal3, medal4, medal5, medal6, medal7, medal8, medal9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilescreen);
        name = (TextView) findViewById(R.id.name);
        score = (TextView) findViewById(R.id.score);
        medal = (TextView) findViewById(R.id.medal);
        lesson1 = (TextView) findViewById(R.id.lesson1);
        lesson2 = (TextView) findViewById(R.id.lesson2);
        lesson3 = (TextView) findViewById(R.id.lesson3);
        lesson4 = (TextView) findViewById(R.id.lesson4);
        lesson5 = (TextView) findViewById(R.id.lesson5);
        lesson6 = (TextView) findViewById(R.id.lesson6);
        lesson7 = (TextView) findViewById(R.id.lesson7);
        lesson8 = (TextView) findViewById(R.id.lesson8);
        lesson9 = (TextView) findViewById(R.id.lesson9);
        profilepic = (ImageView) findViewById(R.id.profilepic);
        medal1 = (ImageView) findViewById(R.id.medal1);
        medal2 = (ImageView) findViewById(R.id.medal2);
        medal3 = (ImageView) findViewById(R.id.medal3);
        medal4 = (ImageView) findViewById(R.id.medal4);
        medal5 = (ImageView) findViewById(R.id.medal5);
        medal6 = (ImageView) findViewById(R.id.medal6);
        medal7 = (ImageView) findViewById(R.id.medal7);
        medal8 = (ImageView) findViewById(R.id.medal8);
        medal9 = (ImageView) findViewById(R.id.medal9);
        // will find different ImageView afterwards
    }
    //if finish one lesson and game score > 75marks --> imageView become visible
    //medal1.setVisibility(View.VISIBLE)

    //total score = sum of every game


}