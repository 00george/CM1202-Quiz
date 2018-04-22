import java.util.ArrayList;

public class Statistic {
    public static void main(String[] args) {
        String schoolName = "Test School";
        String questionTheme = "Computer";
        int[] questionCorrect = {1, 3, 5, 7, 9};
        int[] questionIncorrect = {2, 4, 6, 8, 10};
        int time = 30;

        Record r = new Record();

        r.add(schoolName, questionTheme, questionCorrect, questionIncorrect, time);

        System.out.println(r.records.get(0));
    }
}
