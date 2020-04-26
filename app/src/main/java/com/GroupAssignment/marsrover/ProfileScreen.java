package com.GroupAssignment.marsrover;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.GroupAssignment.marsrover.HomeScreen.userScore;

public class ProfileScreen extends AppCompatActivity {
    TextView notice1, notice2, stage0, stage1, stage2, stage3;
    ImageView medal1, medal2, medal3, medal4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilescreen);
        notice1 = findViewById(R.id.notice1);
        notice2 = findViewById(R.id.notice2);
        stage0 = findViewById(R.id.stage0Text);
        stage1 = findViewById(R.id.stage1Text);
        stage2 = findViewById(R.id.stage2Text);
        stage3 = findViewById(R.id.stage3Text);
        medal1 = findViewById(R.id.medal1);
        medal2 = findViewById(R.id.medal2);
        medal3 = findViewById(R.id.medal3);
        medal4 = findViewById(R.id.medal4);

        if (userScore >= 3) {
            medal1.setVisibility(View.VISIBLE);
            stage0.setVisibility(View.VISIBLE);
            notice1.setVisibility(View.INVISIBLE);
            notice2.setVisibility(View.INVISIBLE);
        }
        if (userScore >= 6) {
            medal2.setVisibility(View.VISIBLE);
            stage1.setVisibility(View.VISIBLE);
        }
        if (userScore >= 9) {
            medal3.setVisibility(View.VISIBLE);
            stage2.setVisibility(View.VISIBLE);
        }
        if (userScore >= 12) {
            medal4.setVisibility(View.VISIBLE);
            stage3.setVisibility(View.VISIBLE);
        }

        //if finish one lesson and game score > 75marks --> imageView become visible
        //medal1.setVisibility(View.VISIBLE)
    }

}