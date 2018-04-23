package Statistic;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class RecordLoader {
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
