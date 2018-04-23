package action;

import question.QuestionSet;
import question.QuestionSetReader;
import quiz.Quiz;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SetUpQuizAction extends Action{

    public SetUpQuizAction(String text){
        super(text);
    }

    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        File files = new File("data/");
        for (File file: files.listFiles()){
            System.out.println(file.getName());
        }

        System.out.println("Please select a quiz: ");
        String filename = in.nextLine();
        QuestionSet qs = QuestionSetReader.readBinary(filename);
        ArrayList<String> schoolOptions = new ArrayList<>();
        System.out.println("Please add some schools: ");

        while(true) {
            String input = in .nextLine();
            if(input.equals("done")){
                break;
            }
            schoolOptions.add(input);
        }

        Quiz quiz = new Quiz(qs,schoolOptions);
        Quiz.currentQuiz = quiz;

        }
    }



