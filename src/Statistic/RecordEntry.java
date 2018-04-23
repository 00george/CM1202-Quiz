package Statistic;

import java.io.*;
import java.util.Arrays;

public class RecordEntry implements Serializable {
    private String schoolName;
    private String questionTheme;
    private int[] questionCorrect;
    private int[] questionIncorrect;
    private int time;

    public RecordEntry(String schoolName, String questionTheme, int[] questionCorrect, int[] questionIncorrect, int time) {
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

    public int[] getQuestionCorrect() {
        return questionCorrect;
    }

    public int[] getQuestionIncorrect() {
        return questionIncorrect;
    }

    public String getStringQuestionCorrect() {
        return Arrays.toString(questionCorrect);
    }

    public String getStringQuestionIncorrect() {
        return Arrays.toString(questionIncorrect);
    }

    public int getTime() {
        return time;
    }

    public String toString() {
        return String.format("%s %s %s %s %d", schoolName, questionTheme, questionCorrect, questionIncorrect, time);
    }
}
