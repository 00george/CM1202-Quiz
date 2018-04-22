import java.io.*;

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

    public String arrayToString() {
        int ss[] = {1, 2, 3};
            String s = String.join(", ", ss);
            return s;
    }

    public String toString() {
        return String.format("School Name: %s", arrayToString());
    }
}
