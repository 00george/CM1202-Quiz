package menu;

import Login.EngagementTeam;
import Login.EngagementTeamLoader;
import action.*;

import java.util.Scanner;

public class AdminMenu extends Menu{

    SetUpQuizAction setUpQuizAction;
    NewQuestionSetAction newQuestionSetAction;
    LoadMenuAction loadMainMenuAction;
    DisplayStatsAction displayStatsAction;

    public AdminMenu(){
        super();



    }

    public void OnLoad(){

        setUpQuizAction = new SetUpQuizAction("Set up quiz.");
        newQuestionSetAction = new NewQuestionSetAction("Create new question set.");
        loadMainMenuAction = new LoadMenuAction(MenuManager.mainMenu,"Go back to main menu.");
        displayStatsAction = new DisplayStatsAction("Display Statistics");
        actions = new Action[]{setUpQuizAction,newQuestionSetAction,loadMainMenuAction,displayStatsAction};
        name = "Engangement team Menu";

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
