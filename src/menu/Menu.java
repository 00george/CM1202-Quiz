package menu;

import action.Action;


public class Menu {

    public String name;
    protected Action[] actions;

    public Menu(){
        actions = new Action[]{};
    }

    public void OnLoad(){

    }

    public void displayMenu(){
        System.out.println(name);
        int counter = 1;
        for (Action action : actions) {
            System.out.println(String.valueOf(counter) + "." + " " + action.getText());
            counter++;
        }
    }

    public void select(int actionNumber){
        if(actionNumber  <= actions.length){
            actions[actionNumber-1].execute();
        } else {
            System.out.println("Please select a valid input");
        }

    }
}
