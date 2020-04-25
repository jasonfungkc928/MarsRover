package com.GroupAssignment.marsrover.Controller;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
            this.getActivity().setTitle(mQuestion.getqTitle());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_question, container, false);

        if(mQuestion != null){
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
        }

        return rootView;
    }
}
