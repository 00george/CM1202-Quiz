package Statistic;

import java.io.*;

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
            File file = new File("data/Records.dat");
            if(!file.exists()){
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/Records.dat"));
                out.writeObject("");
                out.close();
            }
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
