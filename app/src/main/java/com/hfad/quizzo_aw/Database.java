package com.hfad.quizzo_aw;

import android.view.View;

import java.util.ArrayList;

public class Database extends Question {

    private static ArrayList<Question> questions;

    public static ArrayList<Question> setData(String Genre, String followUp, String Question, ArrayList<String> choices, String answer) {
        if (questions == null) {

            createData();
        }

        questions.add(new Question(Genre, Question, choices, answer, followUp));

        return questions;
    }

    private static void createData()
    {

        questions = new ArrayList<Question>();

        ArrayList<String> choices = new ArrayList<String>();
        choices.add("Pacific");
        choices.add("Atlantic");
        choices.add("Arctic");
        choices.add("Indian");
        questions.add(new Question("Geography", "Which ocean is the largest?", choices, "Pacific", "The Pacific Ocean stretches to an astonishing 63.8 million square miles!" ));

        choices.clear();
        choices.add("192");
        choices.add("195");
        choices.add("193");
        choices.add("197");
        questions.add(new Question("Geography", "How many countries are in the world?", choices, "195", "Africa has the most countries of any continent with 54."));

    }

    public static ArrayList<Question>getQuestions()
    {
        System.out.println("Returning Questions");
        return questions;
    }



}