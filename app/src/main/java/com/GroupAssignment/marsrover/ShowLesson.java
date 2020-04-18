package com.GroupAssignment.marsrover;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowLesson extends AppCompatActivity {
    String lesson;
    Button classBut;
    Button output;
    ImageView imageView;
    TableLayout result;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        lesson = (String) extras.get("lesson");
        if (lesson.equals("Print Statement")) {
            setContentView(R.layout.print);
            imageView = findViewById(R.id.imageView);
            result = findViewById(R.id.output);
            classBut = findViewById(R.id.printBut);
            output = findViewById(R.id.printOutBut);
            classBut.setOnClickListener(classClicked);
            output.setOnClickListener(outputClicked);
        }
    }

    private View.OnClickListener classClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            result.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);
        }
    };

    private View.OnClickListener outputClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            result.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.INVISIBLE);
        }
    };
}
