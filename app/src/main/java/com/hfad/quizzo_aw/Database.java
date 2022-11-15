package com.hfad.quizzo_aw;

import android.view.View;

import java.util.ArrayList;

/**
 * Author: Austin Weaver
 * Database that stores all the questions and allows program to call questions
 */
public class Database extends Question {

    private static Database myOnlyDBOBJ;
    //Creates new questions arraylist that will hold questions
    private ArrayList<Question> questions;

    //If the arraylist is empty then fill the arraylist with the hardcoded questions else
    //just return the questions arraylist
    public static Database setData() {
        if (myOnlyDBOBJ == null) {
            myOnlyDBOBJ = new Database();
        }
        return myOnlyDBOBJ;
    }

    public void loadDB()
    {
        //Initiates the arrayList allowing questions to be added
        questions = new ArrayList<Question>();
        createData();
    }

    /**
     * Create Data function that fills the questions arraylist with hard coded questions
     */
    private void createData()
    {

        //For each question fill the choices arraylist and then generate a new question
        ArrayList<String> choices = new ArrayList<String>();
        choices.add("Pacific");
        choices.add("Atlantic");
        choices.add("Arctic");
        choices.add("Indian");
        questions.add(new Question("Geography", "Which ocean is the largest?", choices, "Pacific", "The Pacific Ocean stretches to an astonishing 63.8 million square miles!" ));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("192");
        choices.add("195");
        choices.add("193");
        choices.add("197");
        questions.add(new Question("Geography", "How many countries are in the world?", choices, "195", "Africa has the most countries of any continent with 54."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Mississippi");
        choices.add("Nile");
        choices.add("Congo");
        choices.add("Amazon");
        questions.add(new Question("Geography", "What is the name of the longest river in the world?", choices, "Nile", "Explorer John Hanning Speke discovered the source of the Nile on August 3rd, 1858."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("United States");
        choices.add("China");
        choices.add("Japan");
        choices.add("India");
        questions.add(new Question("Geography", "Which country has the largest population?", choices, "China", "Shanghai is the most populated city in China with a population of 24,870,895."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Mars");
        choices.add("Mercury");
        choices.add("Venus");
        choices.add("Jupiter");
        questions.add(new Question("Geography", "Which planet is closest to Earth?", choices, "Venus", "Even though Venus is the closest, the planet it still ~38 million miles from Earth!"));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Sega");
        choices.add("Nintendo");
        choices.add("Sony");
        choices.add("Atari");
        questions.add(new Question("Video Games", "Which company created the famous plumber Mario?", choices, "Nintendo", "Nintendo created Mario in 1981 for the arcade game Donkey Kong."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Sonic");
        choices.add("Tails");
        choices.add("Knuckles");
        choices.add("Amy");
        questions.add(new Question("Video Games", "What is the name of the famous video character who is a blue hedgehog?", choices, "Sonic", "In some official concept art, Sonic was originally meant to be a rabbit."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Wii Sports");
        choices.add("Grand Theft Auto V");
        choices.add("Tetris");
        choices.add("Minecraft");
        questions.add(new Question("Video Games", "As of 2022, which of the following is the best selling video game of all time?", choices, "Minecraft", "As of 2022, Minecraft has sold over 238 million units."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Place 3 milk, 2 sugar, 1 egg, and 3 wheat in the 3x3 crafting grid.");
        choices.add("Place 2 milk, 3 sugar, 2 eggs, and 3 wheat in the 3x3 crafting grid.");
        choices.add("Place 3 milk, 5 sugar, 6 eggs, and 3 wheat in the 3x6 crafting grid.");
        choices.add("Place 1 milk, 1 sugar, 1 egg, and 1 wheat in the 1x1 crafting grid.");
        questions.add(new Question("Video Games", "How do you craft a cake in Minecraft?", choices, "Place 3 milk, 2 sugar, 1 egg, and 3 wheat in the 3x3 crafting grid.", "Cake is the only food that has to be placed for players to eat it."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Diddy Kong");
        choices.add("Donkey Kong Jr.");
        choices.add("Dixie Kong");
        choices.add("Papa Kong");
        questions.add(new Question("Video Games", "Who is Donkey Kong’s son?", choices, "Donkey Kong Jr", "Donkey Kong Jr. has appeared only in the game Super Mario Kart for Super Nintendo Entertainment System as a playable character celebrating the 10th anniversary of his arcade game and his shared history with Mario."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("1");
        choices.add("5");
        choices.add("4");
        choices.add("10");
        questions.add(new Question("Video Games", "How many Xenoblade Chronicles have been created?", choices, "5", "Xenoblade Chronicles was originally going to be titled Monado: Beginning of the World and was not intended as an entry into the Xeno series."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Black");
        choices.add("White");
        choices.add("Pink");
        choices.add("Brown");
        questions.add(new Question("Animals", "What colour is a polar bear’s skin?", choices, "Black", "Polar bear fur is actually hollow and transparent!"));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Man-o-war");
        choices.add("Box jellyfish");
        choices.add("Irukandji Jellyfish");
        choices.add("Sea Nettle");
        questions.add(new Question("Animals", "Which jellyfish has the deadliest sting?", choices, "Irukandji Jellyfish", "Some jellyfish species are functionally immortal."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("True");
        choices.add("False");
        questions.add(new Question("Animals", "Hyenas scavenge more than lions do.", choices, "False", "Lions actually scavenge for food more than they hunt it."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Grizzly bear");
        choices.add("Polar bear");
        choices.add("Raccoon");
        choices.add("Cat");
        choices.add("Spectacled bear");
        questions.add(new Question("Animals", "What is the giant panda’s closest relative?", choices, "Spectacled bear", "Despite common belief, molecular studies show that pandas are in fact closer to bears than raccoons."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Hippo");
        choices.add("Sloth");
        choices.add("Bats");
        choices.add("Elk");
        choices.add("Fish");
        questions.add(new Question("Animals", "Which one of these animals cannot swim?", choices, "Hippo", "Hippos are the world’s most dangerous land mammal."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Eagles");
        choices.add("Packers");
        choices.add("Cowboys");
        choices.add("76ers");
        choices.add("Ravens");
        questions.add(new Question("Sports", "Who won the first superbowl in NFL history?", choices, "Packers", "The Packers have won the NFL championship 4 times."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("1");
        choices.add("2");
        choices.add("Infinite");
        choices.add("7");
        choices.add("3");
        questions.add(new Question("Sports", "How many NFL teams play in New Jersey and New York?", choices, "3", "The Giants and Jets both play in New Jersey, but are New York based. The Buffalo Bills are the only team that actually plays in New York."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("50");
        choices.add("100");
        choices.add("75");
        choices.add("60");
        questions.add(new Question("Sports", "How many points did Kobe Bryant score in his last NBA game?", choices, "60", "Kobe scored over 60 five times during his career."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("28");
        choices.add("7");
        choices.add("23");
        choices.add("13");
        questions.add(new Question("Sports", "How many gold medals has Michael Phelps been awarded in his olympic career?", choices, "23", "Michael Phelps is the most successful olympian for owning the most medals and most gold medals of any athlete."));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Michael Jordan");
        choices.add("Magic Johnson");
        choices.add("Bill Russell");
        choices.add("LeBron James");
        questions.add(new Question("Sports", "What player has the most NBA Championships in NBA History?", choices, "Bill Russell", "Bill Russell won the NBA championship 11 times in his career!"));

        //For each question fill the choices arraylist and then generate a new question
        choices.clear();
        choices.add("Venus Williams");
        choices.add("Roger Federer");
        choices.add("Rafael Nadal");
        choices.add("Serena Williams");
        choices.add("Novak Djokovic");
        questions.add(new Question("Sports", "Who has earned more Grand Slam single titles during the open era in tennis.", choices, "Serena Williams", "Serena and Her Sister Venus won 14 Grand Slam Doubles titles and three doubles gold medals at the Olympics."));
    }

    /**
     * getQuestions function that returns the questions arraylist
     * @return the questions arraylist
     */
    public ArrayList<Question>getQuestions()
    {
        System.out.println("Returning Questions");
        return questions;
    }

    /**
     * getAllGenres loops through questions and stores each genre uniquely
     * @return the new arraylist with the unique genre
     */
    public ArrayList<String> getAllGenres()
    {
        ArrayList<String> specificGenre = new ArrayList<String>();

        for(int i = 0; i < questions.size(); i++)
        {
            if(!specificGenre.contains(questions.get(i).getGenre()))
            {
                specificGenre.add(questions.get(i).getGenre());
            }
        }
        return specificGenre;
    }

    /**
     * Genreates a new question evertime called
     * @param genre The genre entered in
     * @param question The question to be asked
     * @param choices The choices given by the user
     * @param answer The chosen correct answer determined by the user
     * @param followUp The follow up information about the question being asked
     * @return the arraylist of questions
     */
    public ArrayList<Question> addNewQuestions(String genre, String question, ArrayList<String> choices, String answer, String followUp)
    {
        questions.add(new Question(genre, question, choices, answer, followUp));
        return questions;
    }



}