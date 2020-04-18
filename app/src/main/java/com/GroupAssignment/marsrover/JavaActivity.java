package com.GroupAssignment.marsrover;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JavaActivity extends AppCompatActivity {
    private static final String TAG = "JavaActivity";
    ArrayList<String> lessons = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_lesson);
        lessons.add("Print Statement");
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        JavaAdapter.JavaListener listener = new JavaAdapter.JavaListener() {
            @Override
            public void onClick(View view, int position) {

            }
        };

        JavaAdapter javaAdapter = new JavaAdapter(this, lessons, listener);
        recyclerView.setAdapter(javaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void clickResponse(int position) {
        Log.d(TAG, "clickResponse: called");
        Intent intent = new Intent(JavaActivity.this, ShowLesson.class);
        intent.putExtra( "lesson", lessons.get(position));
        JavaActivity.this.startActivity(intent);
    }
}
