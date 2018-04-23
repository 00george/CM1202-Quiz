package action;
import quiz.Quiz;


public class StartQuizAction extends Action {

    private Quiz quiz;

    public StartQuizAction(Quiz quiz){
        this.quiz = quiz;
    }

    @Override
    public void execute() {
        quiz.start();

    }
}
