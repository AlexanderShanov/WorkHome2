import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Question {

    String QuestionText;
    List<Option> Options;

    public Question(String questionText){
        QuestionText = questionText;
    }
    public void AddOption(boolean correct, String optionText){

        if(Options == null){
            Options = new ArrayList<>();
        }
        Options.add(new Option(correct, optionText));
    }

    public boolean CheckAnswer(int i){

        if(i<0 && i>=Options.size()){
            return false;
        }
        else{
            return Options.get(i).getCorrect();
        }

    }

    public void PrintQuestion(){
        System.out.println(QuestionText);
        for(int i = 0; i < Options.size(); i++)
        {
            System.out.println((i + 1) + " " +  Options.get(i).getText());
        }
    }
}
