package com.GroupAssignment.marsrover.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.GroupAssignment.marsrover.Model.Question;
import com.GroupAssignment.marsrover.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> listStage;
    HashMap<String, List<String>> listQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //insert boolean to check if in widescreen

        expandableListView = findViewById(R.id.stage_list_view);
        listStage = new ArrayList<>();
        listQuestion = new HashMap<>();
        initListData();
    }

    private void initListData() {

    }


}
