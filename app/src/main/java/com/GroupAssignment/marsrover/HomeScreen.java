package com.GroupAssignment.marsrover;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {

    private Button lesson, game, profile, QandA;
    private ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        lesson = (Button) findViewById(R.id.lesson);
        game = (Button) findViewById(R.id.game);
        profile = (Button) findViewById(R.id.profile);
        QandA = (Button) findViewById(R.id.QandA);
        imageView1 = (ImageView) findViewById(R.id.imageView1);

    }

    public void startLesson (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void startGame (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void startProfile (View view) {
        Intent intent = new Intent(this, ProfileScreen.class);
        startActivity(intent);
    }

    public void startQandA (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}