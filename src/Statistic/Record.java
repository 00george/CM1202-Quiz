package Statistic;

import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Record implements Serializable {
    private ArrayList<RecordEntry> records;

    public Record() {
        records = new ArrayList<RecordEntry>();
    }

    public void add(String schoolName, String questionTheme, ArrayList<Integer> questionCorrect, ArrayList<Integer> questionIncorrect, int time) {
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

    public ArrayList<String> getUniqueSchoolName() {
        ArrayList<String> uniqueSchoolName = new ArrayList<String>();

        for (RecordEntry re: records) {
            if (!uniqueSchoolName.contains(re.getSchoolName())) {
                uniqueSchoolName.add(re.getSchoolName());
            }
        }

        return uniqueSchoolName;
    }

    public void scoreBox() {
        ArrayList<String> uniqueSchoolName = getUniqueSchoolName();
        ArrayList<Integer> totalCorrectQuestion = new ArrayList<Integer>();
        ArrayList<Integer> totalTime = new ArrayList<Integer>(uniqueSchoolName.size());

        // init the ArrayList (add 0 to it)
        for (int i = 0; i < uniqueSchoolName.size(); i++) {
            totalCorrectQuestion.add(0);
            totalTime.add(0);
        }

        // counting corrected question and total time for each school
        for (int i = 0; i < uniqueSchoolName.size(); i++) {
            int tmpCorrect = 0;
            int tmpTime = 0;

            for (RecordEntry re: records) {
                if (re.getSchoolName().equals(uniqueSchoolName.get(i))) {
                    tmpCorrect += re.getQuestionCorrect().size();
                    tmpTime += re.getTime();
                }
            }
            totalCorrectQuestion.set(i, tmpCorrect);
            totalTime.set(i, tmpTime);
        }

        String tableFormat = "| %-5d | %-30.30s | %-18d | %-10d |%n";

        System.out.format("+-------+--------------------------------+--------------------+------------+%n");
        System.out.format("|                               SCORE BOX                                  |%n");
        System.out.format("+-------+--------------------------------+--------------------+------------+%n");
        System.out.format("|       | School Name                    | Corrected Question | Total Time |%n");
        System.out.format("+-------+--------------------------------+--------------------+------------+%n");

        for (int i = 0; i < uniqueSchoolName.size(); i++) {
            System.out.format(tableFormat, i + 1, uniqueSchoolName.get(i), totalCorrectQuestion.get(i), totalTime.get(i));
        }

        System.out.format("+-------+--------------------------------+--------------------+------------+%n");
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
