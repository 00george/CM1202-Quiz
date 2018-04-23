package menu;

import action.Action;
import action.SetUpQuizAction;

public class AdminMenu extends Menu{

    SetUpQuizAction setUpQuizAction;

    public AdminMenu(){
        super();
        setUpQuizAction = new SetUpQuizAction("Set up quiz.");
        actions = new Action[]{setUpQuizAction};
        name = "Engangement team Menu";
    }
}
