package com.GroupAssignment.marsrover;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.GroupAssignment.marsrover.Controller.MainActivity;



public class ProfileScreen extends AppCompatActivity {
    TextView notice1, notice2, stage0, stage1, stage2, stage3;
    ImageView medal1, medal2, medal3, medal4;
    Button resetProgressBtn;
    int userScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilescreen);

        this.userScore = getUserScore();
        resetProgressBtn = findViewById(R.id.resetBtn);
        resetProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
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

    private void openDialog() {
        AlertDialog.Builder confirmation = new AlertDialog.Builder(ProfileScreen.this);
        confirmation.setTitle("Are you sure?");
        confirmation.setMessage("This will reset all your progress and achievements.");

        confirmation.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetProgress();
                finish();
                startActivity(getIntent());
            }
        });
        confirmation.setNegativeButton("No", null);
        confirmation.show();
    }

    public int getUserScore(){
        SharedPreferences sharedPref = this.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE);
        return sharedPref.getInt("user_score", 0);
    }

    public void resetProgress(){
        SharedPreferences sharedPref = this.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE);
        sharedPref.edit().putInt("user_score", 0).commit();
        HomeScreen.userScore = 0;
    }

}