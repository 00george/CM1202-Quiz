package Statistic;

import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Record implements Serializable {
    private ArrayList<RecordEntry> records;

    public Record() {
        records = new ArrayList<RecordEntry>();
    }

    public void add(String schoolName, String questionTheme, int[] questionCorrect, int[] questionIncorrect, int time) {
        records.add(new RecordEntry(schoolName, questionTheme, questionCorrect, questionIncorrect, time));
    }

    public void remove(int id) {
        records.remove(id);
    }

    public ArrayList<Integer> largestColumnLength() {
        ArrayList<Integer> columnLength = new ArrayList<Integer>();
        int largestLength = 0;
        for(RecordEntry re: records) {
            System.out.println(re);
        }
        return columnLength;
    }

    public void showTable() {
        String tableFormat = "| %-5d | %-30.30s | %-20.20s | %-42.42s | %-42.42s | %-6d |%n";
        int id = 0;

        System.out.format("+-------+--------------------------------+----------------------+--------------------------------------------+--------------------------------------------+--------+%n");
        System.out.format("| ID    | School Name                    | Question Theme       | Correct Question                           | Wrong Question                             | Time   |%n");
        System.out.format("+-------+--------------------------------+----------------------+--------------------------------------------+--------------------------------------------+--------+%n");

        for(RecordEntry re: records) {
            System.out.format(tableFormat, id, re.getSchoolName(), re.getQuestionTheme(), re.getStringQuestionCorrect(), re.getStringQuestionIncorrect(), re.getTime());
            id++;
        }

        System.out.format("+-------+--------------------------------+----------------------+--------------------------------------------+--------------------------------------------+--------+%n");
    }

    public int findMostCorrectQuestion() {
        int[] invertedIndex = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // 10 questions
        int mostCorrectQuestion = 0;
        int maxValue = 0;

        // add 1 to invertedIndex when question exists
        for (RecordEntry re: records) {
            for (int i: re.getQuestionCorrect()) {
                invertedIndex[i - 1] += 1;
            }
        }

        // find the biggest value in array
        for (int i = 0; i < invertedIndex.length; i++) {
            if (invertedIndex[i] > maxValue) {
                maxValue = invertedIndex[i];
                mostCorrectQuestion = i + 1;
            }
        }
        return mostCorrectQuestion;
    }

    public int findMostIncorrectQuestion() {
        int[] invertedIndex = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // 10 questions
        int mostIncorrectQuestion = 0;
        int maxValue = 0;

        // add 1 to invertedIndex when question exists
        for (RecordEntry re: records) {
            for (int i: re.getQuestionIncorrect()) {
                invertedIndex[i - 1] += 1;
            }
        }

        // find the biggest value in array
        for (int i = 0; i < invertedIndex.length; i++) {
            if (invertedIndex[i] > maxValue) {
                maxValue = invertedIndex[i];
                mostIncorrectQuestion = i + 1;
            }
        }
        return mostIncorrectQuestion;
    }

    public Set<String> getUniqueSchoolName() {
        ArrayList<String> uniqueSchoolName = new ArrayList<String>();

        for (RecordEntry re: records) {
            uniqueSchoolName.add(re.getSchoolName());
        }

        // makes it unique
        Set<String> setUniqueSchoolName = new HashSet<String>(uniqueSchoolName);

        for (String s: setUniqueSchoolName) {
            System.out.println(s);
        }

        return setUniqueSchoolName;
    }

    public void leaderboard() {
        // TODO
        String[] schoolName;
        int[] correctQuestionCount;
        int[] timeTotal;


    }

    public void save(String filename) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(this);
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
