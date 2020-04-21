package com.GroupAssignment.marsrover;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        // will find another imageView later

        /**create or load userScore**/
        int userScore = getUserScore();

        /**showing the user's Score**/
        TextView score = findViewById(R.id.tvScore);
        score.setText("Score: "+userScore);

    }

    public int getUserScore(){
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        return sharedPref.getInt("user_score", 0);
    }
    public void setUserScore(int newScore){
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putInt("user_score", newScore);
        editor.commit();
    }

    public void startLesson (View view) {
        Intent intent = new Intent(this, JavaActivity.class);
        startActivity(intent);
    }
    //navigate to the game page
    public void startGame (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void startProfile (View view) {
        Intent intent = new Intent(this, ProfileScreen.class);
        startActivity(intent);
    }
    //navigate to QandA page
    public void startQandA (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}