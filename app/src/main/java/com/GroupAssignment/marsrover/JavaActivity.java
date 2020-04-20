package com.GroupAssignment.marsrover;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JavaActivity extends AppCompatActivity {
    private static final String TAG = "JavaActivity";
    ArrayList<String> lessons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_lesson);
        lessons = lessonsList();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        JavaAdapter.JavaListener listener = new JavaAdapter.JavaListener() {
            @Override
            public void onClick(View view, int position) {
                clickResponse(position);
            }
        };

        JavaAdapter javaAdapter = new JavaAdapter(this, lessons, listener);
        recyclerView.setAdapter(javaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void clickResponse(int position) {
        Log.d(TAG, "clickResponse: called" + position);
        Intent intent = new Intent(JavaActivity.this, ShowLesson.class);
        intent.putExtra("lesson", lessons.get(position));
        JavaActivity.this.startActivity(intent);
    }

    public ArrayList<String> lessonsList() {
        ArrayList<String> lessons = new ArrayList<>();
        lessons.add("Print Statement");
        lessons.add("If statement");
        lessons.add("While Loops");
        lessons.add("For Loops");
        lessons.add("OOP");
        return lessons;
    }
}