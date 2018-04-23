package Statistic;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.ArrayList;

public class RecordEntry implements Serializable {
    private String schoolName;
    private String questionTheme;
    private ArrayList<Integer> questionCorrect;
    private ArrayList<Integer> questionIncorrect;
    private int time;

    public RecordEntry(String schoolName, String questionTheme, ArrayList<Integer> questionCorrect, ArrayList<Integer> questionIncorrect, int time) {
        this.schoolName = schoolName;
        this.questionTheme = questionTheme;
        this.questionCorrect = questionCorrect;
        this.questionIncorrect = questionIncorrect;
        this.time = time;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getQuestionTheme() {
        return questionTheme;
    }

    public ArrayList<Integer> getQuestionCorrect() {
        return questionCorrect;
    }

    public ArrayList<Integer> getQuestionIncorrect() {
        return questionIncorrect;
    }

    public String getStringQuestionCorrect() {
        String output = "";
        for (int i = 0; i < questionCorrect.size(); i++) {
            output += String.valueOf(questionCorrect.get(i));
        }
        return output;
    }

    public String getStringQuestionIncorrect() {
        String output = "";
        for (int i = 0; i < questionCorrect.size(); i++) {
            output += String.valueOf(questionIncorrect.get(i));
        }
        return output;
    }

    public int getTime() {
        return time;
    }

    public String toString() {
        return String.format("%s %s %s %s %d", schoolName, questionTheme, questionCorrect, questionIncorrect, time);
    }
}
