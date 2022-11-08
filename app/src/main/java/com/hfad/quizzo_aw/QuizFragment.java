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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        TextView tvNum = view.findViewById(R.id.Number);
        TextView tvQuest = view.findViewById(R.id.Question);
        RadioGroup rgButtons = view.findViewById(R.id.radioGroup);
        RadioButton radia1 = view.findViewById(R.id.radia1);
        RadioButton radia2 = view.findViewById(R.id.radia2);
        RadioButton radia3 = view.findViewById(R.id.radia3);
        RadioButton radia4 = view.findViewById(R.id.radia4);
        Button btnSubmit = view.findViewById(R.id.buttonSubmit);
        String chosenGenre = QuizFragmentArgs.fromBundle(requireArguments()).getChoice();

        ArrayList<Question> questions = getQuestions();


        System.out.println("Recieved Questions");
        System.out.println(questions.get(1).getGenre());

        for(int i = 0; i < questions.size();i++)
        {
            if(questions.get(i).getGenre().equals(chosenGenre))
            {
                counter++;
            }
        }

        isPressed = false;

        questionsCalled(chosenGenre, questions, radia1, radia2, radia3, radia4, tvNum, tvQuest);

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



                if(selectedAnswer.equals(questions.get(questionNum).getAnswer()))
                {
                    Toast.makeText(getActivity(),"Correct!",Toast.LENGTH_SHORT).show();
                    answers.add("Correct");
                }
                else
                {
                    Toast.makeText(getActivity(),"Incorrect!",Toast.LENGTH_SHORT).show();
                    answers.add("Incorrect");
                }
                System.out.println(selectedAnswer + questions.get(questionNum).getAnswer());
                questionNum += 1;
                isPressed = true;

                System.out.println(questionNum + "" + counter);
                if(questionNum == counter)
                {
                    QuizFragmentDirections.ActionQuizFragmentToScoreFragment action =
                            QuizFragmentDirections.actionQuizFragmentToScoreFragment(answers.toArray(new String[answers.size()]));

                    Navigation.findNavController(v).navigate(action);
                }
                else {
                    questionsCalled(chosenGenre, questions, radia1, radia2, radia3, radia4, tvNum, tvQuest);
                }
            }
        });

        return view;
    }

    public void questionsCalled(String chosenGenre, ArrayList<Question> questions, RadioButton radia1, RadioButton radia2, RadioButton radia3, RadioButton radia4, TextView tvNum, TextView tvQuest)
    {
        if(questions.get(questionNum).getGenre().equals(chosenGenre))
        {
            tvNum.setText("Question #" + (questionNum));
            tvQuest.setText(questions.get(questionNum).getQuestion());
            for(int i = 0; i < questions.get(questionNum).getChoices().size(); i++)
            {
                if(!questions.get(questionNum).getChoices().get(i).equals("")) {
                    if(i == 0)
                    {
                        if(questions.get(questionNum).getChoices().get(0).isEmpty())
                        {
                            radia1.setEnabled(false);
                            radia1.setText("");
                        }
                        else {
                            radia1.setEnabled(true);
                            radia1.setText(questions.get(questionNum).getChoices().get(0));
                        }
                    }
                    if(i == 1)
                    {
                        if(questions.get(questionNum).getChoices().get(1).isEmpty())
                        {
                            radia2.setEnabled(false);
                            radia2.setText("");
                        }
                        else
                        {
                            radia2.setEnabled(true);
                            radia2.setText(questions.get(questionNum).getChoices().get(1));
                        }
                    }

                    if(i == 2)
                    {
                        if(questions.get(questionNum).getChoices().get(2).isEmpty())
                        {
                            radia3.setEnabled(false);
                            radia3.setText("");
                        }
                        else
                        {
                            radia3.setEnabled(true);
                            radia3.setText(questions.get(questionNum).getChoices().get(2));
                        }
                    }
                    if(i == 3)
                    {
                        if(questions.get(questionNum).getChoices().get(3).isEmpty())
                        {
                            radia4.setEnabled(false);
                            radia4.setText("");
                        }
                        else
                        {
                            radia4.setEnabled(true);
                            radia4.setText(questions.get(questionNum).getChoices().get(3));
                        }
                    }
                }
            }
        }
    }
}