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
        numbersCorrect = new ArrayList<>();
        numbersWrong = new ArrayList<>();

        Scanner in = new Scanner(System.in);


        System.out.println("Please select your school: ");
        for(String schoolOp : schoolOptions){
            System.out.println(schoolOp);
        }
        school = in.nextLine();


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

    public void outputStats(){
        String filename = "records.dat";

        int[] numCorrectArray = numbersCorrect.toArray(new Integer[numbersCorrect.size()]);

        Record r = new Record();

        // <----- Load records from a dat file ----->
        try {
            r = RecordLoader.load("Records.dat");
        } catch (Exception e) {
            // Do nothing
        }

        r.add(school,questionSet.getTheme(),);

        // save object to a binary file
        r.save(filename);


        r.getUniqueSchoolName();

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
