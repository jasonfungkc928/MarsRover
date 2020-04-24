package com.GroupAssignment.marsrover;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.GroupAssignment.marsrover.HomeScreen.userScore;

public class ProfileScreen extends AppCompatActivity {

    private TextView name, score, medal, lesson1, lesson2, lesson3, lesson4;
    private ImageView profilepic, medal1, medal2, medal3, medal4;

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
        profilepic = (ImageView) findViewById(R.id.profilepic);
        medal1 = (ImageView) findViewById(R.id.medal1);
        medal2 = (ImageView) findViewById(R.id.medal2);
        medal3 = (ImageView) findViewById(R.id.medal3);
        medal4 = (ImageView) findViewById(R.id.medal4);


        name.setText("Student");
        score.setText(userScore);

        if (userScore >= 3)
                medal1.setVisibility(View.VISIBLE);
        if (userScore >= 6)
            medal2.setVisibility(View.VISIBLE);
        if (userScore >= 9)
            medal3.setVisibility(View.VISIBLE);
        if (userScore >= 12)
            medal4.setVisibility(View.VISIBLE);

    }

}