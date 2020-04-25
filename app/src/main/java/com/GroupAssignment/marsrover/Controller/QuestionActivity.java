package com.GroupAssignment.marsrover.Controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.GroupAssignment.marsrover.R;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        if(savedInstanceState == null){
            Bundle arguments = new Bundle();
            arguments.putString(QuestionFragment.ARG_QUESTION_NAME, getIntent().getStringExtra(QuestionFragment.ARG_QUESTION_NAME));
            QuestionFragment fragment = new QuestionFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.question_fragment, fragment)
                    .commit();
        }
    }
}
