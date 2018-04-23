package menu;

import action.Action;


public class Menu {

    protected String name;
    protected Action[] actions;

    public Menu(){

    }

    public Menu(Action[] actions){
        this.actions = actions;

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
