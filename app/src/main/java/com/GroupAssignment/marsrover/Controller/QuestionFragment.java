package com.GroupAssignment.marsrover.Controller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.GroupAssignment.marsrover.HomeScreen;
import com.GroupAssignment.marsrover.JavaActivity;
import com.GroupAssignment.marsrover.LevelScreenAdapter;
import com.GroupAssignment.marsrover.Model.Question;
import com.GroupAssignment.marsrover.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {
    public static final String ARG_QUESTION_NAME = "questionName";
    private Question mQuestion;
    private static ArrayList<Question> mQuestions = new ArrayList();
    String selectedAnswer;

    int userScore;
    LevelScreenAdapter l = new LevelScreenAdapter();

    boolean updateScore = false;

    public QuestionFragment() {
        // Required empty public constructor
    }


    public static void getQuestions(){
        mQuestions.clear();
        Question q = new Question();
        ArrayList<Question> questionList = q.createQuestions();

        for(int i = 0; i < questionList.size(); i++){
            mQuestions.add(questionList.get(i));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getQuestions();
        if (getArguments().containsKey(ARG_QUESTION_NAME)) {

            for(Question question : mQuestions){
                //question name = getargument questionname, mquestion = quesion;
                if(question.getqTitle().equals(getArguments().getString(ARG_QUESTION_NAME))){
                    mQuestion = question;
                }
            }
            //this.getActivity().setTitle(mQuestion.getqTitle());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_question, container, false);

        if(mQuestion != null){

            userScore = getUserScore();

            for(int i = 0; i < mQuestions.size(); i++){
                if(mQuestions.get(i).getqTitle().equalsIgnoreCase(mQuestion.getqTitle())){
                    if(userScore == i){
                        updateScore = true;
                    }
                    break;
                }
            }
        //set all the views in the question fragment
            String ansA = mQuestion.getAnswers()[0];
            String ansB = mQuestion.getAnswers()[1];
            String ansC = mQuestion.getAnswers()[2];
            ((TextView) rootView.findViewById(R.id.tvQTitle)).setText(mQuestion.getqTitle());
            ((TextView) rootView.findViewById(R.id.tvQText)).setText(mQuestion.getqText());
            ((Button) rootView.findViewById(R.id.ansA)).setText(ansA);
            ((Button) rootView.findViewById(R.id.ansB)).setText(ansB);
            ((Button) rootView.findViewById(R.id.ansC)).setText(ansC);
            ((ImageView)rootView.findViewById(R.id.questionImage)).setImageResource(mQuestion.getImgResource());

            //setting on click listeners for buttons a,b,c
            rootView.findViewById(R.id.ansA).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedAnswer =  String.valueOf(((Button) v.findViewById(R.id.ansA)).getText());
                    boolean result = isAnswerCorrect(mQuestion, selectedAnswer);
                    showPopUp(result);
                }
            });
            rootView.findViewById(R.id.ansB).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedAnswer =  String.valueOf(((Button) v.findViewById(R.id.ansB)).getText());
                    boolean result = isAnswerCorrect(mQuestion, selectedAnswer);
                    showPopUp(result);
                }
            });
            rootView.findViewById(R.id.ansC).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedAnswer =  String.valueOf(((Button) v.findViewById(R.id.ansC)).getText());
                    boolean result = isAnswerCorrect(mQuestion, selectedAnswer);
                    showPopUp(result);
                }
            });
        }

        return rootView;
    }

    private void showPopUp(boolean result) {
        String alertTitle,alertMessage;
        AlertDialog.Builder resultPopup = new AlertDialog.Builder(this.getActivity());
        if(result){
            alertTitle = "CORRECT";
            if(userScore ==11){
                alertMessage = "Nice job, Now that you have a firm grasp on these concepts, try writing up a java program yourself!";
            }else{
                alertMessage = "Nice job, you can now move on to the next question";
            }

            if(updateScore){
                setUserScore(userScore+1);
            }
        }else{
            alertTitle = "INCORRECT!";
            alertMessage = ":( Not to worry! head back to the lessons and try again";
        }
        resultPopup.setTitle(alertTitle);
        resultPopup.setMessage(alertMessage);
        resultPopup.setPositiveButton("To Level Select", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Context context = getActivity();
                Intent intent = new Intent(context, MainActivity.class);

                context.startActivity(intent);
            }
        });
        resultPopup.setNeutralButton("To Lessons", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Context context = getActivity();
                Intent intent = new Intent(context, JavaActivity.class);

                context.startActivity(intent);
            }
        });


        resultPopup.show();

    }

    public boolean isAnswerCorrect(Question question, String answer){
        boolean result = false;
        if(answer.equalsIgnoreCase(question.getCorrectAnswer())){
            result = true;
        }

        return result;
    }

    public int getUserScore(){
        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("USER_DATA", Context.MODE_PRIVATE);
        return sharedPref.getInt("user_score", 0);
    }

    public void setUserScore(int newScore){
        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("USER_DATA", Context.MODE_PRIVATE);
        userScore = newScore;
        l.setUserScore(newScore);
        sharedPref.edit().putInt("user_score", newScore).commit();
    }
}
