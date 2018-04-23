package menu;

import Login.EngagementTeam;
import Login.EngagementTeamLoader;
import action.Action;
import action.LoadMenuAction;
import action.NewQuestionSetAction;
import action.SetUpQuizAction;

import java.util.Scanner;

public class AdminMenu extends Menu{

    SetUpQuizAction setUpQuizAction;
    NewQuestionSetAction newQuestionSetAction;
    LoadMenuAction loadMainMenuAction;

    public AdminMenu(){
        super();


        setUpQuizAction = new SetUpQuizAction("Set up quiz.");
        newQuestionSetAction = new NewQuestionSetAction("Create new question set.");
        loadMainMenuAction = new LoadMenuAction(MenuManager.mainMenu,"Go back to main menu.");
        actions = new Action[]{setUpQuizAction,newQuestionSetAction,loadMainMenuAction};
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
            et = EngagementTeamLoader.load(filename);
        } catch (Exception e) {
            // Do nothing
        }

        if(!et.verify(username,password)){
            MenuManager.currentMenu = new MainMenu();
        }
    }
}
