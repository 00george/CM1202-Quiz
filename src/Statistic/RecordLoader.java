package Statistic;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class RecordLoader {
    public static void main(String[] args) {
        String filename = "Records.dat";

        Record r = new Record();

        try {
            r = load(filename);
        } catch (Exception e) {
            // Do nothing
        }


        r.showTable();


    }

    public static Record load(String filename) throws Exception {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/" + filename));
            Record r = (Record)in.readObject();
            in.close();
            return r;
        }
        catch (Exception e) {
            throw e; // re-raise exception
        }
    }
}
