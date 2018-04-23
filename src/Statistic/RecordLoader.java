package Statistic;

<<<<<<< HEAD
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
=======
import java.io.*;
>>>>>>> 9db20932a79a88fbe19184c20dced316112be4a2

public class RecordLoader {
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
