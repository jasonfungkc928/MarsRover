package com.GroupAssignment.marsrover;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class LevelScreenAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> listStage;
    HashMap<String, List<String>> listQuestion;
    int userScore;



    public LevelScreenAdapter(Context context, List<String> listStage, HashMap<String,List<String>> listQuestion, int userScore) {
        this.context = context;
        this.listStage = listStage;
        this.listQuestion = listQuestion;
        this.userScore = userScore;
    }


    @Override
    public int getGroupCount() {
        return listStage.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listQuestion.get(this.listStage.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listStage.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listQuestion.get(this.listStage.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String group = (String) getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.level_screen, null);
        }

        TextView textView = convertView.findViewById(R.id.list_parent);

        int stage = Integer.parseInt(group.replaceAll("[^\\d.]", ""));
        int requiredScore = stage*3;

        if(userScore < requiredScore){
            //add imageview, display locked lock or greyed out star
            textView.setText(group);
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }else {
            textView.setText(group);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child = (String) getChild(groupPosition, childPosition);
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.stage_row, null);
        }
        TextView textView = convertView.findViewById(R.id.level);
            textView.setText(child);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
