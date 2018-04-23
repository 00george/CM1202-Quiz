package action;
import quiz.Quiz;


public class StartQuizAction extends Action {

    private Quiz quiz;


    public StartQuizAction(String text){
        super(text);
        quiz = Quiz.currentQuiz;
    }

    public void SetQuiz(Quiz quiz){
        this.quiz = quiz;
    }

    @Override
    public void execute() {
        if(quiz != null){
            quiz.start();
        } else {
            System.out.println("Please get a member of the engagement team to set up the quiz.");
        }


    }
}
