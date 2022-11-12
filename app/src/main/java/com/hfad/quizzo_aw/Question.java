package com.hfad.quizzo_aw;

import java.util.ArrayList;

/**
 * Author: Austin Weaver
 * Question files the allows the program to create new questions. Each question will have a genre,
 * question, 1 to 6 choices, a answer, and a follow up explain some information about the question.
 */
public class Question {

    private String genre; //The genre of each question
    private String question; //The question being asked
    private ArrayList<String> choices = new ArrayList<String>(); //The choices the are being given to choose from
    private String answer; //The correct answer for the question being asked
    private String followUp; //The follow up of information about the question

    //Default constructor that generates a question with nothing if nothing is entered
    public Question()
    {
        genre = "";
        question = "";
        choices.add("");
        answer = "";
        followUp = "";
    }

    //Non default constructor that generates the question based off the information sent in
    public Question(String g, String q, ArrayList<String> c, String a, String f)
    {
        genre = g;
        question = q;
        for(int i = 0; i < c.size(); i++)
        {
            choices.add(c.get(i));
        }
        answer = a;
        followUp = f;
    }

    //Setters and getter for each item in the question
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public ArrayList<String> getChoices() {
        return choices;
    }
    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getFollowUp() {
        return followUp;
    }
    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }
}
