package menu;

import Login.EngagementTeam;
import Login.EngangementTeamLoader;
import action.Action;
import action.NewQuestionSetAction;
import action.SetUpQuizAction;

import java.util.Scanner;

public class AdminMenu extends Menu{

    SetUpQuizAction setUpQuizAction;
    NewQuestionSetAction newQuestionSetAction;

    public AdminMenu(){
        super();


        setUpQuizAction = new SetUpQuizAction("Set up quiz.");
        newQuestionSetAction = new NewQuestionSetAction("Create new question set.");
        actions = new Action[]{setUpQuizAction,newQuestionSetAction};
        name = "Engangement team Menu";
    }

    public void OnLoad(){
        String filename = "Engagement.dat";

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a username: ");
        String username = in.nextLine();
        System.out.println("Please enter a password: ");
        String password = in.nextLine();

        EngagementTeam et = new EngagementTeam();

        try {
            et = EngangementTeamLoader.load(filename);
        } catch (Exception e) {
            // Do nothing
        }

        if(!et.verify(username,password)){
            MenuManager.currentMenu = new MainMenu();
        }
    }
}
