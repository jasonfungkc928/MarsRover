package com.GroupAssignment.marsrover.Controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.GroupAssignment.marsrover.Model.Question;
import com.GroupAssignment.marsrover.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {
    private static final String ARG_QUESTION_NAME = "questionName";
    private Question mQuestion;
    private ArrayList<Question> mQuestions = new ArrayList();

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_QUESTION_NAME)) {

            for(Question question : mQuestions){
                //question name = getargument questionname, mquestion = quesion;
                if(true){

                }
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);

        if(mQuestion != null){
            //set all the views in the question fragment
        }
    }
}
