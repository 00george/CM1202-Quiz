package Statistic;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class RecordLoader {
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
