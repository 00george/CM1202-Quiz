package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionSetReader {
    //everytime it hits new line new question
    public static QuestionSet read(String filepath){
        ArrayList<Question> questions = new ArrayList<>();
        Scanner in = null;
        File file = new File("QuestionSets/" + filepath);
        String questionText = "";
        Question tempQuestion;
        String theme = "";
        int answerIndex = 0;
        String[] answers = new String[4];
        int count = 0;
        boolean firstLine = true;
        try {
            //Initialize scanner with the file
            in = new Scanner(file);

            //Loop until the file has no more lines to read
            while (in.hasNextLine()) {
                //Read the next line

                if(firstLine){
                    theme = in.nextLine();
                }

                String line = in.nextLine();
                if(!line.equals("")){
                    String[] parts = line.split("");
                    if(parts[0].equals("*") && parts[1].equals("*")){
                        questionText = line.split("\\*")[3];
                    } else if (parts[line.length() -1].equals("*")){
                        answerIndex = count;
                        String line_temp = line.replace("*","");
                        answers[count] = line_temp;
                        count++;
                    } else {
                        answers[count] = line;
                        count++;
                    }

                } else {
                    questions.add(new Question(questionText,answers,answerIndex));
                    count = 0;
                    answers = new String[4];
                }


            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        QuestionSet qs = new QuestionSet();
        qs.setQuestions(questions);
        qs.setTheme(theme);
        return qs;
    }

}
