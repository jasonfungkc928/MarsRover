package com.GroupAssignment.marsrover;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.GroupAssignment.marsrover.Controller.QuestionActivity;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class LevelScreenAdapter extends BaseExpandableListAdapter {

    /**TO DO:
     * - Make child objects launch question activities
     * - Make locked child objects un-openable
     * - */

    Context context;
    List<String> listStage;
    HashMap<String, List<String>> listQuestion;
    int userScore;
    //boolean inwide
    //call generate questions method, get list of 12 questions.
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String qTitle = (String) v.getTag();
            System.out.println(qTitle);
            //make intent, put question name in it
            //launch question activity with intent
            Context context = v.getContext();
            Intent intent = new Intent(context, QuestionActivity.class);
            intent.putExtra()
        }
    };



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

        //textView.setText(String.valueOf(userScore));
        if(userScore+1 >= requiredScore){
            //add imageview, display locked lock or greyed out star
            textView.setText(group+" Unlocked");
        }else if (requiredScore > userScore+1){

            textView.setText(group+" locked");
            //textView.setTextColor(context.getResources().getColor(R.color.darkOrange));
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String group = (String) getGroup(groupPosition);
        String child = (String) getChild(groupPosition, childPosition);
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.stage_row, null);
        }
        TextView textView = convertView.findViewById(R.id.level);

        /**This code requires that the only integers in the parent names are 0,1,2,3 resepctively*/
        int stage = Integer.parseInt(group.replaceAll("[^\\d.]", ""));
        int question = Integer.parseInt(child.replaceAll("[^\\d.]", ""));
        int requiredScore = (stage*3)+question;


        if(userScore+1 == requiredScore){
            textView.setText(child+" unlocked");
            convertView.setTag(child);
            convertView.setOnClickListener(mOnClickListener);
        }else if (requiredScore > userScore+1) {
            //add imageview, display locked lock or greyed out star
            textView.setText(child+" locked");
            textView.setClickable(false);
        }else{
            textView.setText(child+" completed");
            convertView.setTag(child);
            convertView.setOnClickListener(mOnClickListener);
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        String group = (String) getGroup(groupPosition);
        String child = (String) getChild(groupPosition, childPosition);

        int stage = Integer.parseInt(group.replaceAll("[^\\d.]", ""));
        int question = Integer.parseInt(child.replaceAll("[^\\d.]", ""));
        int requiredScore = (stage*3)+question;

        if (requiredScore > userScore+1) {
            return false;
        }else{
            return true;
        }
    }
}
