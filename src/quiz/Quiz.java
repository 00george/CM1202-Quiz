package quiz;

import question.Question;
import question.QuestionSet;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    private QuestionSet questionSet;
    private Question currentQuestion;
    private int numCorrect;
    private School school;
    private ArrayList<Question> questions;

    public Quiz(QuestionSet questionSet){
        this.questionSet = questionSet;
    }

    public void start(){
        Scanner in = new Scanner(System.in);

        //TimeoutTask timeoutTask = new TimeoutTask();
        //Timer timeoutTimer = new Timer();

        questions = questionSet.getQuestions();
        for(int i = 0;i< questions.size();i++){
            System.out.println("Question: " + i);
            System.out.println(questions.get(i).getQuestion());
            int counter = 1;
            for(String answer:questions.get(i).getAnswers()){
                System.out.println(counter + ". " + answer);
            }
            System.out.println("Please select an answer: ");
            int selection = getUserInput();
            if(checkAnswer(questions.get(i),selection)){
                System.out.println("Correct answer");
                numCorrect++;
            } else {
                displayInstantFeedback(questions.get(i));
            }
            System.out.println("Press any key to continue");
            in.nextLine();
        }
    }

    public void exir(){

    }

    public void timeout(){

    }

    public boolean checkAnswer(Question question,int selection){
        if(question.getCorrectAnswerindex() == selection - 1){
            return true;
        }
        return false;
    }

    public int getUserInput(){
        Scanner in = new Scanner(System.in);
        in.nextLine();
        return in.nextInt();
    }

    public void displayInstantFeedback(Question question){
        System.out.println("Answer Incorrect");
        String correctAnswer = question.getAnswers()[question.getCorrectAnswerindex()];
        System.out.println("The correct answer was: " + correctAnswer);
    }

    public void displayResults(){

    }
}
