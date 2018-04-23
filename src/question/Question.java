package question;

public class Question {

    private String question;
    private String[] answers;
    private int correctAnswerindex;

    public Question(String question,String[] answers,int correctAnswerindex){
        this.question = question;
        this.answers = answers;
        this.correctAnswerindex = correctAnswerindex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getCorrectAnswerindex() {
        return correctAnswerindex;
    }

    public void setCorrectAnswerindex(int correctAnswerindex) {
        this.correctAnswerindex = correctAnswerindex;
    }
}
