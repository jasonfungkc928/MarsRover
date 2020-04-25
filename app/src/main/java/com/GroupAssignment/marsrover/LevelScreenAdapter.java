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
import android.widget.ImageView;
import android.widget.TextView;

import com.GroupAssignment.marsrover.Controller.MainActivity;
import com.GroupAssignment.marsrover.Controller.QuestionActivity;
import com.GroupAssignment.marsrover.Controller.QuestionFragment;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class LevelScreenAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> listStage;
    HashMap<String, List<String>> listQuestion;
    static int userScore;

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
            intent.putExtra(QuestionFragment.ARG_QUESTION_NAME, qTitle);
            context.startActivity(intent);
        }
    };


    public LevelScreenAdapter(){}

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


        if(userScore >= requiredScore){
            //add imageview, display locked lock or greyed out star
            textView.setText(group+" Unlocked");
        }else if (requiredScore > userScore){

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
        ImageView status = convertView.findViewById(R.id.status);


        String s = group.replaceAll("[^0-9]", "");
        String q = child.replaceAll("[^0-9]", "");
        /**This code requires that the only integers in the parent names are 0,1,2,3 resepctively*/
        int stage = Integer.parseInt(s.replaceAll("[.]", ""));
        int question = Integer.parseInt(q.replaceAll("[.]", ""));
        int requiredScore = (stage*3)+question;

        textView.setText(child);
        if(userScore+1 == requiredScore){
            status.setImageResource(R.drawable.unlocked);
            convertView.setTag(child);
            convertView.setOnClickListener(mOnClickListener);
        }else if (requiredScore > userScore+1) {
            //add imageview, display locked lock or greyed out star
            textView.setText(child);
            status.setImageResource(R.drawable.locked);
            convertView.setTag(child);
            textView.setClickable(false);
        }else{
            status.setImageResource(R.drawable.completed);
            convertView.setTag(child);
            convertView.setOnClickListener(mOnClickListener);
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        String group = (String) getGroup(groupPosition);
        String child = (String) getChild(groupPosition, childPosition);

        String s = group.replaceAll("[^0-9]", "");
        String q = child.replaceAll("[^0-9]", "");
        /**This code requires that the only integers in the parent names are 0,1,2,3 resepctively*/
        int stage = Integer.parseInt(s.replaceAll("[.]", ""));
        int question = Integer.parseInt(q.replaceAll("[.]", ""));
        int requiredScore = (stage*3)+question;

        if (requiredScore > userScore+1) {
            //return false;
            return true;
        }else{
            return true;
        }
    }

    public void setUserScore(int newScore){
        userScore = newScore;
        MainActivity m = new MainActivity();
        m.setTvScore();
        notifyDataSetChanged();
    }
}
