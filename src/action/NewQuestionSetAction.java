package action;

import question.Question;
import question.QuestionSet;
import question.QuestionSetWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class NewQuestionSetAction extends Action {

    public NewQuestionSetAction(String text){
        super(text);
    }

    @Override
    public void execute() {
        Scanner in = new Scanner();
        QuestionSet newSet = new QuestionSet();
        System.out.println("Please enter a theme: ");
        String theme = in.nextLine();
        for(int i = 0;i<10;i++){
            System.out.println("Adding Question: " + i + 1 + "//10");
            newSet.getQuestions().add(getNewQusetion());
        }
        QuestionSetWriter.saveBinary(theme + ".dat",newSet);
        System.out.println("Saved as: " + theme + ".dat");
    }

    public Question getNewQusetion(){
        ArrayList<String> answers = new ArrayList<>();
        Scanner in = new Scanner();
        System.out.println("Please enter the question: ");
        String questionText = in.nextLine();
        for(int i = 0;i<4;i++){
            System.out.println("Please enter an answer: ");
            String answer = in.nextLine();
            answers.add(answer;)
        }
        System.out.println("Please enter the index of the correct answer (0-3)");
        int correctIndex = in.nextInt();
        in.nextLine();
        Question question = new Question(questionText,answers.toArray(),correctIndex);
        return question;
    }
}
