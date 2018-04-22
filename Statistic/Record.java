import java.io.*;
import java.util.ArrayList;

public class Record implements Serializable {
    public ArrayList<RecordEntry> records;

    public Record() {
        records = new ArrayList<RecordEntry>();
    }

    public void add(String schoolName, String questionTheme, int[] questionCorrect, int[] questionIncorrect, int time) {
        records.add(new RecordEntry(schoolName, questionTheme, questionCorrect, questionIncorrect, time));
    }

}
