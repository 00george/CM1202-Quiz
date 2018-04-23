package action;

import menu.Menu;
import menu.MenuManager;


public class LoadMenuAction extends Action{
    private Menu menuToLoad;

    public LoadMenuAction(Menu menuToLoad,String text){
        super(text);
        this.menuToLoad = menuToLoad;
    }

    public void execute(){
        System.out.println(MenuManager.currentMenu.name);
        //System.out.println(MenuManager.lastMenu.name);
        MenuManager.lastMenu = MenuManager.currentMenu;
        MenuManager.currentMenu = menuToLoad;

        menuToLoad.OnLoad();
    }
}
