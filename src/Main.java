import menu.MainMenu;
import menu.MenuManager;
import question.Question;
import question.QuestionSet;
import question.QuestionSetReader;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {



    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        MenuManager.currentMenu = mainMenu;

        Scanner scanner = new Scanner(System.in);
        //loop here
        while (true) {
            MenuManager.currentMenu.displayMenu();
            System.out.println("");
            System.out.println("Please Enter the number of the action you wish to do");
            int input = scanner.nextInt();
            MenuManager.currentMenu.select(input);
        }
    }
}
