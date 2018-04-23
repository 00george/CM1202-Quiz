import java.io.*;


public class BinaryWriter {

    public static void write(Object o,String filepath){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
