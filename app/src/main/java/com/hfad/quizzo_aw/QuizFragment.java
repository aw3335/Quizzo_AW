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
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment {

    int questionNum = 0;
    Boolean isPressed = true;
    String selectedAnswer = "";
    int counter = 0;
    ArrayList<String> answers = new ArrayList<String>();

    public static final String QUESTIONNUM_KEY = "questionNum";
    public static final String PRESSED_KEY = "isPressed";
    public static final String SELECTEDANSWER_KEY = "selectedAnswer";
    public static final String COUNTER_KEY = "counter";
    public static final String ANSWERS_KEY = "answers";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        TextView tvNum = view.findViewById(R.id.Number);
        TextView tvQuest = view.findViewById(R.id.Question);
        RadioGroup rgButtons = view.findViewById(R.id.radioGroup);
        RadioButton radia1 = view.findViewById(R.id.radia1);
        RadioButton radia2 = view.findViewById(R.id.radia2);
        RadioButton radia3 = view.findViewById(R.id.radia3);
        RadioButton radia4 = view.findViewById(R.id.radia4);
        RadioButton radia5 = view.findViewById(R.id.radia5);
        RadioButton radia6 = view.findViewById(R.id.radia6);
        Button btnSubmit = view.findViewById(R.id.buttonSubmit);
        String chosenGenre = QuizFragmentArgs.fromBundle(requireArguments()).getChoice();

        ArrayList<Question> questions = getQuestions();
        ArrayList<Question> genreQuestions = new ArrayList<Question>();

        for(int i = 0; i < questions.size();i++)
        {
            if(questions.get(i).getGenre().equals(chosenGenre))
            {
                counter++;
                genreQuestions.add(questions.get(i));
            }
        }

        isPressed = false;

        if(savedInstanceState != null)
        {
            questionNum = savedInstanceState.getInt(QUESTIONNUM_KEY);
            isPressed = savedInstanceState.getBoolean(PRESSED_KEY);
            selectedAnswer = savedInstanceState.getString(SELECTEDANSWER_KEY);
            answers = savedInstanceState.getStringArrayList(ANSWERS_KEY);
        }
        questionsCalled(chosenGenre, genreQuestions, radia1, radia2, radia3, radia4,radia5, radia6, tvNum, tvQuest);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                questionNum += 1;
                isPressed = true;
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

    public void questionsCalled(String theChosenGenre, ArrayList<Question> genreQuestions, RadioButton radia1, RadioButton radia2, RadioButton radia3, RadioButton radia4, RadioButton radia5, RadioButton radia6, TextView tvNum, TextView tvQuest)
    {
        tvNum.setText("Question #" + (questionNum + 1));
        tvQuest.setText(genreQuestions.get(questionNum).getQuestion());
        for(int i = 0; i < genreQuestions.get(questionNum).getChoices().size(); i++)
        {
            if(!genreQuestions.get(questionNum).getChoices().get(i).equals("")) {
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

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState)
    {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt(QUESTIONNUM_KEY, questionNum);
        saveInstanceState.putBoolean(PRESSED_KEY, isPressed);
        saveInstanceState.putString(SELECTEDANSWER_KEY, selectedAnswer);
        saveInstanceState.putInt(COUNTER_KEY, counter);
        saveInstanceState.putStringArrayList(ANSWERS_KEY, answers);

    }

}


