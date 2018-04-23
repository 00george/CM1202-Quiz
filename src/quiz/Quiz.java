package quiz;

import Statistic.Record;
import Statistic.RecordLoader;
import question.Question;
import question.QuestionSet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Quiz {

    public static Quiz currentQuiz;
    private long time;
    private QuestionSet questionSet;
    private Question currentQuestion;
    private int numCorrect;
    public ArrayList<String> schoolOptions;
    private String school;
    private ArrayList<Question> questions;

    private ArrayList<Integer> numbersCorrect;
    private ArrayList<Integer> numbersWrong;

    public Quiz(QuestionSet questionSet,ArrayList<String> schoolOptions){
        this.questionSet = questionSet;
        this.schoolOptions = schoolOptions;
    }

    public void start(){
        long startTime = System.currentTimeMillis();

        numbersCorrect = new ArrayList<>();
        numbersWrong = new ArrayList<>();

        Scanner in = new Scanner(System.in);



        for(String schoolOp : schoolOptions){
            System.out.println(schoolOp);
        }
        school = in.nextLine();
        System.out.println("Please select your school: ");



        questions = questionSet.getQuestions();
        for(int i = 0;i< questions.size();i++){
            int questionNum = i +1;
            System.out.println("Question: " + questionNum);
            System.out.println(questions.get(i).getQuestion());
            int counter = 1;
            for(String answer:questions.get(i).getAnswers()){
                System.out.println(counter + ". " + answer);
                counter++;
            }
            System.out.println("Please select an answer: ");
            int selection = getUserInput();
            if(selection == -1){
                return;
            }
            if(checkAnswer(questions.get(i),selection)){
                System.out.println("Correct answer");
                numbersCorrect.add(i);
                numCorrect++;
            } else {
                displayInstantFeedback(questions.get(i));
                numbersWrong.add(i);
            }
            System.out.println("Press any key to continue");
            in.nextLine();


        }
            displayResults();
            time = (System.currentTimeMillis() - startTime) / 1000;
            outputStats();

    }

    public void outputStats(){
        String filename = "Records.dat";



        Record r = new Record();

        // <----- Load records from a dat file ----->
        try {
            r = RecordLoader.load("Records.dat");
        } catch (Exception e) {
            // Do nothing
        }

        r.add(school,questionSet.getTheme(),numbersCorrect,numbersWrong,(int)time);

        // save object to a binary file
        r.save("data/Records.dat");

    }


    public boolean checkAnswer(Question question,int selection){
        if(question.getCorrectAnswerindex() == selection - 1){
            return true;
        }
        return false;
    }

    public int getUserInput(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if(input.equals("exit")){
            return -1;
        }
        return Integer.valueOf(input);
    }

    public void displayInstantFeedback(Question question){
        System.out.println("Answer Incorrect");
        String correctAnswer = question.getAnswers()[question.getCorrectAnswerindex()];
        System.out.println("The correct answer was: " + correctAnswer);
    }

    public void displayResults(){
        System.out.println(numCorrect + "/" + "10");
    }
}
