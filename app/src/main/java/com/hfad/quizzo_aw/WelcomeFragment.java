package com.hfad.quizzo_aw;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Austin Weaver
 * Welcome fragment that allows the user to take the quiz or to add a question to the database
 */
public class WelcomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        //The buttons and spinner from the fragment_welcome xml
        Button btnAdd = view.findViewById(R.id.buttonAdd);
        Button btnQuiz = view.findViewById(R.id.buttonPractice); 
        Spinner spnGenre = view.findViewById(R.id.Genres);

        //If the application is loading for the first time, then load the hardcoded questions
        if(savedInstanceState == null)
        {
            Database.setData();
        }

        //Creates new arraylist with all the genres in the database uniquely
        ArrayList<String> genres = Database.getAllGenres();

        //If the arraylist is not empty then fills the spinner with those genres
        if(!genres.isEmpty()) {
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, genres);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnGenre.setSelection(1);
            spnGenre.setAdapter(adapter);
        }

        //When the quiz button is clicked then navigate the screen to the quiz fragment and start the
        //quiz with the selected genre
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String genre = spnGenre.getSelectedItem().toString();
                WelcomeFragmentDirections.ActionWelcomeFragmentToQuizFragment action =
                        WelcomeFragmentDirections.actionWelcomeFragmentToQuizFragment(genre);

                Navigation.findNavController(v).navigate(action);
            }
        });

        //When the add button is clicked move the screen to the add fragment allowing user to add a question
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_welcomeFragment_to_addFragment);
            }
        });
        return view;
    }


}