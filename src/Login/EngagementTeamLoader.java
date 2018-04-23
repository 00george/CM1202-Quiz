package Login;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class EngagementTeamLoader {

    public static EngagementTeam load(String filename) throws Exception {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data/" + filename));
            EngagementTeam r = (EngagementTeam)in.readObject();
            in.close();
            return r;
        }
        catch (Exception e) {
            System.out.println("\nProblem reading file: " + filename);
            e.printStackTrace();
            throw e; // re-raise exception
        }
    }
}
