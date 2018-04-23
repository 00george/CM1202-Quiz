package Login;

import java.io.*;
import java.util.ArrayList;


public class EngagementTeam implements Serializable {
    private ArrayList<EngagementTeamEntry> EngagementTeams;

    public EngagementTeam() {
        EngagementTeams = new ArrayList<EngagementTeamEntry>();
    }

    public void add(String username, String password) {
        EngagementTeams.add(new EngagementTeamEntry(username, password));
    }

    public boolean verify(String username, String password) {
        for (EngagementTeamEntry ete: EngagementTeams) {
            if (ete.getUsername().equals(username)) {
                if (ete.getPassword().equals(password)) {
                    System.out.println("Login successful!");
                    return true;
                } else {
                    System.out.println("Username and Password doesn't match!");
                    return false;
                }
            }
        }
        System.out.println("Username incorrect!");
        return false;
    }

    public void save(String filename) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(this);
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
