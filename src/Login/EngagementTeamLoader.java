package Login;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class EngagementTeamLoader {

    public static EngagementTeam load(String filename) throws Exception {
        try {

            Scanner input = new Scanner(System.in);
            Path folder = Paths.get("data/Engagement.dat");
            File file = new File("data/Engagement.dat");
            if(!file.exists()){
                Files.createDirectories(folder.getParent());
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/Engagement.dat"));
                out.close();
                System.out.println("NO LOGIN ACCOUNT");
                System.out.println("Please enter a new username: ");
                String username = input.nextLine();
                System.out.println("Please enter a new password: ");
                String password = input.nextLine();
                EngagementTeam et = new EngagementTeam();
                et.add(username,password);
                et.save("data/Engagement.dat");
            }

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
