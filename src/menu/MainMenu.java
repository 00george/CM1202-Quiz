package menu;

import action.Action;
import action.LoadMenuAction;
import action.StartQuizAction;

public class MainMenu extends Menu {

    StartQuizAction startQuizAction;
    LoadMenuAction loadAdminMenu;

    public MainMenu(){
        super();
        startQuizAction = new StartQuizAction("Start Quiz");
        loadAdminMenu = new LoadMenuAction(new AdminMenu(),"Engagement team options");
        actions = new Action[]{startQuizAction,loadAdminMenu};
        name = "Main Menu";


    }

}
