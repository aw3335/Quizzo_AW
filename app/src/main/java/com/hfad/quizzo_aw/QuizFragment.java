package com.hfad.quizzo_aw;

import static com.hfad.quizzo_aw.Database.getQuestions;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 *Author: Austin Weaver
 * Quiz Fragment - Takes stored quiz questions and pulls questions that are in the genre chosen from
 * the welcome fragment.
 */
public class QuizFragment extends Fragment {

    int questionNum = 0; //The current question that the program will look at
    String selectedAnswer = ""; //Holds the current selected answer from the radio buttons
    int counter = 0; //Counter to holds how many questions there are per the selected Genre
    ArrayList<String> answers = new ArrayList<String>(); //Holds all the answer chosen by the quiz taker

    public static final String QUESTIONNUM_KEY = "questionNum"; //Key for the question number
    public static final String SELECTEDANSWER_KEY = "selectedAnswer"; //Key for the selected answer
    public static final String COUNTER_KEY = "counter"; //Key for the counter
    public static final String ANSWERS_KEY = "answers"; // Key for the answer

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Stores the layout when called
        super.onSaveInstanceState(savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        //All the Textviews , radio buttons, and button from fragment_quiz
        TextView tvNum = view.findViewById(R.id.Number);
        TextView tvQuest = view.findViewById(R.id.Question);
        RadioButton radia1 = view.findViewById(R.id.radia1);
        RadioButton radia2 = view.findViewById(R.id.radia2);
        RadioButton radia3 = view.findViewById(R.id.radia3);
        RadioButton radia4 = view.findViewById(R.id.radia4);
        RadioButton radia5 = view.findViewById(R.id.radia5);
        RadioButton radia6 = view.findViewById(R.id.radia6);
        Button btnSubmit = view.findViewById(R.id.buttonSubmit);
        //The genre chosen by quiz taker from the welcome fragment
        String chosenGenre = QuizFragmentArgs.fromBundle(requireArguments()).getChoice();

        //Stores all the questions from the database in the questions arraylist
        ArrayList<Question> questions = getQuestions();
        //Creates new arraylist that will hold all the questions of a specific genre
        ArrayList<Question> genreQuestions = new ArrayList<Question>();

        //For every question created, if the any question matches the specified genre, then store that question
        for(int i = 0; i < questions.size();i++)
        {
            if(questions.get(i).getGenre().equals(chosenGenre))
            {
                counter++;
                genreQuestions.add(questions.get(i));
            }
        }

        //If the instance state is not null, the call the saved variables
        if(savedInstanceState != null)
        {
            questionNum = savedInstanceState.getInt(QUESTIONNUM_KEY);
            selectedAnswer = savedInstanceState.getString(SELECTEDANSWER_KEY);
            answers = savedInstanceState.getStringArrayList(ANSWERS_KEY);
        }
        //Generates the next question
        questionsCalled(chosenGenre, genreQuestions, radia1, radia2, radia3, radia4,radia5, radia6, tvNum, tvQuest);

        //If button submit is selected then perform specific actions
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //If a radio button is selected then set the selectedAnswer to that choice.
                if(radia1.isChecked())
                {
                    selectedAnswer = radia1.getText().toString();
                }
                if(radia2.isChecked())
                {
                    selectedAnswer = radia2.getText().toString();
                }
                if(radia3.isChecked())
                {
                    selectedAnswer = radia3.getText().toString();
                }
                if(radia4.isChecked())
                {
                    selectedAnswer = radia4.getText().toString();
                }
                if(radia5.isChecked())
                {
                    selectedAnswer = radia5.getText().toString();
                }
                if(radia6.isChecked())
                {
                    selectedAnswer = radia6.getText().toString();
                }

                //If the selected Answer is equals to the right answer, then let use know they are
                //correct. Then add correct or incorrect to the answer arrayList.
                if(selectedAnswer.equals(genreQuestions.get(questionNum).getAnswer()))
                {
                    Toast.makeText(getActivity(),"Correct!",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getActivity(), genreQuestions.get(questionNum).getFollowUp(), Toast.LENGTH_LONG).show();
                    answers.add("Correct");
                }
                else
                {
                    Toast.makeText(getActivity(),"Incorrect!",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getActivity(), genreQuestions.get(questionNum).getFollowUp(), Toast.LENGTH_LONG).show();
                    answers.add("Incorrect");
                }
                //After question has been completed then go to the next question
                questionNum += 1;

                //If the number or question equals the total questions then navigate to the next screen,
                //else generate the next question.
                if(questionNum == counter || questionNum == 0)
                {
                    QuizFragmentDirections.ActionQuizFragmentToScoreFragment action =
                            QuizFragmentDirections.actionQuizFragmentToScoreFragment(answers.toArray(new String[answers.size()]));
                    Navigation.findNavController(v).navigate(action);
                }
                else {
                    questionsCalled(chosenGenre, genreQuestions, radia1, radia2, radia3, radia4,radia5, radia6, tvNum, tvQuest);
                }
            }
        });
        return view;
    }

    /**
     * questionCalled function that display the sent in question to the user
     * @param theChosenGenre The genre chosen by the user
     * @param genreQuestions All the question of the chosen genre
     * @param radia1 The radio button 1
     * @param radia2 The radio button 2
     * @param radia3 The radio button 3
     * @param radia4 The radio button 4
     * @param radia5 The radio button 5
     * @param radia6 The radio button 6
     * @param tvNum The textview for the number of the current question
     * @param tvQuest The textview for the current question being displayed
     */
    public void questionsCalled(String theChosenGenre, ArrayList<Question> genreQuestions, RadioButton radia1, RadioButton radia2, RadioButton radia3, RadioButton radia4, RadioButton radia5, RadioButton radia6, TextView tvNum, TextView tvQuest)
    {
        //Set the number of question to the questionnum plus one
        tvNum.setText("Question #" + (questionNum + 1));
        //Sets the question to the current questions, question
        tvQuest.setText(genreQuestions.get(questionNum).getQuestion());
        //For each item in the choices arraylist for the question loop through and print the information
        for(int i = 0; i < genreQuestions.get(questionNum).getChoices().size(); i++)
        {
            //If the choice is empty then just skip this loop through
            if(!genreQuestions.get(questionNum).getChoices().get(i).equals("")) {
                //If choice 0 has a option then print it out else set the radio button to invisible and not selectable
                if(i == 0)
                {
                    radia1.setEnabled(true);
                    radia1.setText(genreQuestions.get(questionNum).getChoices().get(0));
                    radia1.setVisibility(View.VISIBLE);
                }
                else if(i != 0 && i < 0)
                {
                    radia1.setEnabled(false);
                    radia1.setText("");
                    radia1.setVisibility(View.INVISIBLE);
                }
                //If choice 1 has a option then print it out else set the radio button to invisible and not selectable
                if(i == 1)
                {
                    radia2.setEnabled(true);
                    radia2.setText(genreQuestions.get(questionNum).getChoices().get(1));
                    radia2.setVisibility(View.VISIBLE);
                }
                else if (i != 1 && i < 1)
                {
                    radia2.setEnabled(false);
                    radia2.setText("");
                    radia2.setVisibility(View.INVISIBLE);
                }
                //If choice 2 has a option then print it out else set the radio button to invisible and not selectable
                if(i == 2)
                {
                    radia3.setEnabled(true);
                    radia3.setText(genreQuestions.get(questionNum).getChoices().get(2));
                    radia3.setVisibility(View.VISIBLE);
                }
                else if(i != 2 && i < 2)
                {
                    radia3.setEnabled(false);
                    radia3.setText("");
                    radia3.setVisibility(View.INVISIBLE);
                }
                //If choice 3 has a option then print it out else set the radio button to invisible and not selectable
                if(i == 3)
                {
                    radia4.setEnabled(true);
                    radia4.setText(genreQuestions.get(questionNum).getChoices().get(3));
                    radia4.setVisibility(View.VISIBLE);

                }
                else if(i != 3 && i < 3)
                {
                    radia4.setEnabled(false);
                    radia4.setText("");
                    radia4.setVisibility(View.INVISIBLE);
                }
                //If choice 4 has a option then print it out else set the radio button to invisible and not selectable
                if(i == 4)
                {
                    radia5.setEnabled(true);
                    radia5.setText(genreQuestions.get(questionNum).getChoices().get(4));
                    radia5.setVisibility(View.VISIBLE);

                }
                else if(i != 4 && i < 4)
                {
                    radia5.setEnabled(false);
                    radia5.setText("");
                    radia5.setVisibility(View.INVISIBLE);
                }
                //If choice 5 has a option then print it out else set the radio button to invisible and not selectable
                if(i == 5)
                {
                    radia6.setEnabled(true);
                    radia6.setText(genreQuestions.get(questionNum).getChoices().get(5));
                    radia6.setVisibility(View.VISIBLE);

                }
                else if(i != 5 && i < 5)
                {
                    radia6.setEnabled(false);
                    radia6.setText("");
                    radia6.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    /**
     * On screen rotate then save the required info for the app to continue like nothing happened
     * @param saveInstanceState
     */
    @Override
    public void onSaveInstanceState(Bundle saveInstanceState)
    {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt(QUESTIONNUM_KEY, questionNum);
        saveInstanceState.putString(SELECTEDANSWER_KEY, selectedAnswer);
        saveInstanceState.putInt(COUNTER_KEY, counter);
        saveInstanceState.putStringArrayList(ANSWERS_KEY, answers);

    }

}


