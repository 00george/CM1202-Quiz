package menu;

import action.Action;
import action.LoadMenuAction;
import action.StartQuizAction;

public class MainMenu extends Menu {

    StartQuizAction startQuizAction;
    LoadMenuAction loadAdminMenu;

    public MainMenu(){
        super();



    }

    public void OnLoad(){
        startQuizAction = new StartQuizAction("Start Quiz");
        loadAdminMenu = new LoadMenuAction(MenuManager.adminMenu,"Engagement team options");
        actions = new Action[]{startQuizAction,loadAdminMenu};
        name = "Main Menu";
    }

}
