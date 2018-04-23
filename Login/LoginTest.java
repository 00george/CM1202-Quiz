import java.util.Scanner;
import java.io.*;

public class LoginTest {
    public static void main(String[] args) {
        String filename = "Engagement.dat";

        Scanner in = new Scanner(System.in);

        EngagementTeam et = new EngagementTeam();

        try {
            et = load(filename);
        } catch (Exception e) {
            // Do nothing
        }

        et.verify("Tommy", "123456");
        et.verify("IncorrectID", "123456");
        et.verify("Arno", "T11111");
    }

    public static EngagementTeam load(String filename) throws Exception {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            EngagementTeam r = (EngagementTeam)in.readObject();
            in.close();
            return r;
        }
        catch (Exception e) {
            System.out.println("\nProblem reading file: " + filename);
            throw e; // re-raise exception
        }
    }
}
