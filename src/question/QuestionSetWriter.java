package question;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QuestionSetWriter {

    public static void save(String filepath,QuestionSet questionSet){
        Path file = Paths.get("QuestionSets/" + filepath);
        try {
            BufferedWriter writer = Files.newBufferedWriter(file);
            writer.write(questionSet.getTheme());
            writer.newLine();
            for(Question question : questionSet.getQuestions()){
                writer.write("**" + question.getQuestion());
                for(int i = 0;i < question.getAnswers().length;i++){
                    if(i == question.getCorrectAnswerindex()){
                        writer.write(question.getAnswers()[i] + "*");
                    } else {
                        writer.write(question.getAnswers()[i]);
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
