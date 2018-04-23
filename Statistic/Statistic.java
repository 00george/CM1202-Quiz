import java.util.ArrayList;
import java.io.*;

public class Statistic {
    public static void main(String[] args) {
        String filename = "records.dat";

        Record r = new Record();

        // <----- Load records from a dat file ----->
        try {
            r = load("Records.dat");
        } catch (Exception e) {
            // Do nothing
        }
        // <----- Load records from a dat file ----->



        // <----- Testing Records ----->
        String[] schoolName = {"Cardiff Uni", "Glyndwr Uni", "Middlesex Uni", "Abertay Uni", "Birmingham City Uni"};
        String[] questionTheme = {"Computer", "Art", "Computer", "Computer", "Bio"};
        int[][] questionCorrect = {{1, 3, 5, 7, 9}, {1, 3}, {1, 2, 3, 4, 5}, {1, 6, 7, 8, 9}, {1, 6, 7, 8, 9}};
        int[][] questionIncorrect = {{2, 4, 6, 8, 10}, {2, 4, 5, 6, 7, 8, 9, 10}, {6, 7, 8, 9, 10}, {2, 3, 4, 5, 10}, {2, 3, 4, 5, 10}};
        int[] time = {30, 15, 30, 25, 22};
        // <----- Testing Records ----->


        // <----- Add Records ----->
        for(int i = 0; i < 5; i++) {
            r.add(schoolName[i], questionTheme[i], questionCorrect[i], questionIncorrect[i], time[i]);
        }
        // <----- Add Records ----->



        // save object to a binary file
        r.save(filename);

        r.showTable();

        System.out.println(r.findMostCorrectQuestion());
        System.out.println(r.findMostIncorrectQuestion());

        r.getUniqueSchoolName();
    }

    public static Record load(String filename) throws Exception {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            Record r = (Record)in.readObject();
            in.close();
            return r;
        }
        catch (Exception e) {
            throw e; // re-raise exception
        }
    }
}
