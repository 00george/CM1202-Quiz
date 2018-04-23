package Login;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class EngangementTeamLoader {

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
