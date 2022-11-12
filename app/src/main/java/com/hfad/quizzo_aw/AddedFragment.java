package com.hfad.quizzo_aw;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Author: Austin Weaver
 * Allows the user to see that a question has been added to the database
 */
public class AddedFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_added, container, false);

        //The button from the xml file
        Button btnReturn = view.findViewById(R.id.MainMenu);

        //When the return button is selected bring the user to the fragment_Welcome xml
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_addedFragment_to_welcomeFragment);
            }
        });
        return view;
    }
}