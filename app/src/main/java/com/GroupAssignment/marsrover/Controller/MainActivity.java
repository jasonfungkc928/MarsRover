package com.GroupAssignment.marsrover.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.GroupAssignment.marsrover.LevelScreenAdapter;
import com.GroupAssignment.marsrover.Model.Question;
import com.GroupAssignment.marsrover.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> listStage;
    HashMap<String, List<String>> listQuestion;
    LevelScreenAdapter adapter;
    TextView tvScore;

    public int getUserScore(){
        SharedPreferences sharedPref = this.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE);
        return sharedPref.getInt("user_score", 0);
    }

    public void setUserScore(int newScore){
        SharedPreferences sharedPref = this.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE);
        sharedPref.edit().putInt("user_score", newScore).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //insert boolean to check if in widescreen
        tvScore = findViewById(R.id.levelTitle);
        tvScore.setText("Score: "+getUserScore());
        expandableListView = findViewById(R.id.stage_list_view);
        listStage = new ArrayList<>();
        listQuestion = new HashMap<>();
        adapter = new LevelScreenAdapter(this, listStage, listQuestion, getUserScore());
        expandableListView.setAdapter(adapter);
        initListData();
    }

    private void initListData() {
        listStage.add(getString(R.string.stage0));
        listStage.add(getString(R.string.stage1));
        listStage.add(getString(R.string.stage2));
        listStage.add(getString(R.string.stage3));

        String[] array;

        List<String> list0 = new ArrayList<>();
        array = getResources().getStringArray(R.array.stage0);
        for(String question: array){
            list0.add(question);
        }

        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.stage1);
        for(String question: array){
            list1.add(question);
        }

        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.stage2);
        for(String question: array){
            list2.add(question);
        }

        List<String> list3 = new ArrayList<>();
        array = getResources().getStringArray(R.array.stage3);
        for(String question: array){
            list3.add(question);
        }

        listQuestion.put(listStage.get(0), list0);
        listQuestion.put(listStage.get(1), list1);
        listQuestion.put(listStage.get(2), list2);
        listQuestion.put(listStage.get(3), list3);
        adapter.notifyDataSetChanged();
    }

    public void setTvScore(){
        if(tvScore != null){
            tvScore = findViewById(R.id.levelTitle);
            tvScore.setText("Score: "+getUserScore());
        }

    }

}
