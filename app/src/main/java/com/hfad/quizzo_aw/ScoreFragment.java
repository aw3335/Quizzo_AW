package com.hfad.quizzo_aw;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Author: Austin Weaver
 * Score Fragment - takes the answer from the quiz fragment and for every one correct, the program
 * keep track. Then the program divides that number by the total questions and times by 100 to get
 * the percent correct.
 */
public class ScoreFragment extends Fragment {

    int counter = 0; //The total correct from the quiz

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_score, container, false);

        //The textviews and buttons from the fragment_score xml
        TextView tvCorrect = view.findViewById(R.id.NumCorrect);
        TextView tvPercent = view.findViewById(R.id.PercentCorrect);
        Button btnReturn = view.findViewById(R.id.Return);

        //The stored array from the quiz fragment
        String[] answer = ScoreFragmentArgs.fromBundle(requireArguments()).getAnswers();

        //For every correct answer stored add one to the counter
        for(int i = 0; i < answer.length; i++)
        {
            if(answer[i].equals("Correct"))
            {
                counter++;
            }
        }

        //Sets tvcorrect to the total number of question answered correctly
        tvCorrect.setText("Number Correct: " + counter);
        //Formats a string to calculate the total percent correctly answered and then sets it
        String s = String.format("Percentage: %.2f", (counter * 1.0 / answer.length) * 100);
        tvPercent.setText(s + "%");

        //When the return button is clicked navigate back to the welcome screen
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_scoreFragment_to_welcomeFragment);
            }
        });
        return view;
    }
}