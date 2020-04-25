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
    Button classBut, classBut1;
    Button output,output1;
    ImageView imageView, imageView1;
    TableLayout result, result1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        lesson = (String) extras.get("lesson");
        if (lesson.equals("Print Statement")) {
            setContentView(R.layout.print);
        } else if (lesson.equals("While Loops")) {
            setContentView(R.layout.while_loop);
        } else if (lesson.equals("For Loops")){
            setContentView(R.layout.for_loop);
        } else if (lesson.equals("OOP")) {
            setContentView(R.layout.oop);
        } else if (lesson.equals("Arithmetic Operators")){
            setContentView(R.layout.arithmetic);
        } else if (lesson.equals("Comparison Operators")) {
            //setContentView(R.layout.comparison);
        }
        else {
            if (lesson.equals("If statement")) {
                setContentView(R.layout.if_stm);
            }
            imageView1 = findViewById(R.id.imageView1);
            classBut1 = findViewById(R.id.className1);
            output1 = findViewById(R.id.output1);
            result1 = findViewById(R.id.outputScreen1);
            classBut1.setOnClickListener(classClicked1);
            output1.setOnClickListener(outputClicked1);
        }
        imageView = findViewById(R.id.imageView);
        result = findViewById(R.id.outputScreen);
        classBut = findViewById(R.id.className);
        output = findViewById(R.id.output);
        classBut.setOnClickListener(classClicked);
        output.setOnClickListener(outputClicked);
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
    private View.OnClickListener classClicked1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            result1.setVisibility(View.INVISIBLE);
            imageView1.setVisibility(View.VISIBLE);
        }
    };

    private View.OnClickListener outputClicked1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            result1.setVisibility(View.VISIBLE);
            imageView1.setVisibility(View.INVISIBLE);
        }
    };
}
