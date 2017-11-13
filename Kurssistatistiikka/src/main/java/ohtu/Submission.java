package ohtu;

import java.util.*;

public class Submission {
    private int week;
    private int hours;
    private List<Integer >exercises;

    

    public void setHours(int hours) {
        this.hours = hours;
    }





    public int getHours() {
        return hours;
    }

    public List<Integer> getExercises() {
        return exercises;
    }

    public void setExercises(List<Integer> exercises) {
        this.exercises = exercises;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }
    public String exercisesToString() {
        String s = "";
        for (Integer exercise : exercises) {
            s += exercise + ", ";
        }
        return s.substring(0, s.length() - 2);
    }

    @Override
    public String toString() {
        return "Viikko "+week + ", aikaa käytetty: " + hours + " tuntia" + ". Tehdyt tehtävät: " + exercisesToString();
    }
    
}