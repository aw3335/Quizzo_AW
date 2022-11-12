package com.hfad.quizzo_aw;

import android.database.DataSetObserver;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Author: Austin Weaver
 * Add Fragment - Allows the user to enter in information and add a question to the question arraylist.
 */
public class AddFragment extends Fragment {

    //Creates new quest arraylist that will hold the questions
    private ArrayList<Question> quest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        //All the spinners, buttons, and text views from the fragment_add xml
        Spinner spinnerChoices = view.findViewById(R.id.spinnerChoices);
        Button btnAdd = view.findViewById(R.id.btnAdd);
        TextView Genre = view.findViewById(R.id.Genre);
        TextView followUp = view.findViewById(R.id.FollowUpFact);
        TextView Question = view.findViewById(R.id.Text);
        TextView answer1 = view.findViewById(R.id.choice1);
        TextView answer2 = view.findViewById(R.id.choice2);
        TextView answer3 = view.findViewById(R.id.choice3);
        TextView answer4 = view.findViewById(R.id.choice4);
        TextView answer5 = view.findViewById(R.id.choice5);
        TextView answer6 = view.findViewById(R.id.choice6);

        //Creates new arraylist the will hold all the choices for each question
        ArrayList<String> choices = new ArrayList<String>();

        //When the user selects the add button, the program takes all entered information and creates a new question.
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If any choice has not been filled out then dont add it to the choices arraylist
                if(!answer1.getText().toString().equals(""))
                {
                    choices.add(answer1.getText().toString());
                }
                if(!answer2.getText().toString().equals(""))
                {
                    choices.add(answer2.getText().toString());
                }
                if(!answer3.getText().toString().equals(""))
                {
                    choices.add(answer3.getText().toString());
                }
                if(!answer4.getText().toString().equals(""))
                {
                    choices.add(answer4.getText().toString());
                }
                if(!answer5.getText().toString().equals(""))
                {
                    choices.add(answer5.getText().toString());
                }
                if(!answer6.getText().toString().equals(""))
                {
                    choices.add(answer6.getText().toString());
                }

                //Creates and sets the chosenAnswer to empty string
                String chosenAnswer = "";

                //Whatever option from the spinner is selected, make that the chosenAnswer
                if(spinnerChoices.getSelectedItem().toString().equals("Choice 1"))
                {
                    chosenAnswer = answer1.getText().toString();
                }
                else if(spinnerChoices.getSelectedItem().toString().equals("Choice 2"))
                {
                    chosenAnswer = answer2.getText().toString();
                }
                else if(spinnerChoices.getSelectedItem().toString().equals("Choice 3"))
                {
                    chosenAnswer = answer3.getText().toString();
                }
                else if(spinnerChoices.getSelectedItem().toString().equals("Choice 4"))
                {
                    chosenAnswer = answer4.getText().toString();
                }
                else if(spinnerChoices.getSelectedItem().toString().equals("Choice 5"))
                {
                    chosenAnswer = answer5.getText().toString();
                }
                else
                {
                    chosenAnswer = answer6.getText().toString();
                }
                //Once all information has been gather the program will add a new question to the database
                quest = Database.addNewQuestions(Genre.getText().toString(), Question.getText().toString(), choices, chosenAnswer, followUp.getText().toString());

                //Once the question has been added then more to the question added fragment
                Navigation.findNavController(v).navigate(R.id.action_addFragment_to_addedFragment);
            }
        });
        return view;
    }
}