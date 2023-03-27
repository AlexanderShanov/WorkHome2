import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quest {

    private int CorrectCount;
    private int WrongCount;

    private List<Question> Questions;

    public static Quest Create(){
        Quest quest = new Quest();

        Question  question1 = new Question("Сколько букв сейчас в русском алфавите?");
        question1.AddOption(false, "30");
        question1.AddOption(false, "32");
        question1.AddOption(true, "33");
        quest.AddQuestion(question1);

        Question  question2 = new Question("Сколько дней в январе?");
        question2.AddOption(false, "29");
        question2.AddOption(false, "30");
        question2.AddOption(true, "31");
        quest.AddQuestion(question2);

        Question  question3 = new Question("Последний свет в радуге");
        question3.AddOption(false, "Белый");
        question3.AddOption(true, "Фиолетовый");
        question3.AddOption(false, "Синий");
        quest.AddQuestion(question3);

        return quest;
    }

    public void AddQuestion(Question question){
        if(Questions == null){
            Questions = new ArrayList<Question>();
        }
        Questions.add(question);
    }

    public void PassTheTest(){
        Scanner scanner = new Scanner(System.in);
        for (var question: Questions) {
            question.PrintQuestion();

            System.out.print("Ваш ответ:");

            if(scanner.hasNext()){
                int numberAswer = scanner.nextInt();
                int i = question.CheckAnswer(numberAswer - 1) ? CorrectCount++ : WrongCount++;
            }
        }
    }

    public void PringResultQuest(){
        System.out.println("Результат: правильно " + CorrectCount + ", неправельно " + WrongCount);
    }
}
