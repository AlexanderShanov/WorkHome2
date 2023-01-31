import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int correctCount = 0;
        int wrongCount = 0;

        String[] questions = {
                "Сколько букв сейчас в русском алфавите?",
                "Сколько дней в январе?",
                "Последний свет в радуге"
        };

        String[][] answerOptions = {
                { "30", "32", "33"},
                {"29", "30", "31"},
                {"Белый", "Фиолетовый", "Синий"}
        };

        String[] correctAnswers = {"33","31", "Фиолетовый"};

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < answerOptions.length; i++){
            System.out.println(questions[i]);
            for (int j = 0; j < answerOptions.length; j++) {
                System.out.println(String.valueOf(j + 1) + " " + answerOptions[i][j]);
            }

            System.out.print("Ваш ответ:");

            if(scanner.hasNextInt()){
                int numberAnswer = scanner.nextInt();
                if(numberAnswer>0
                        && numberAnswer<= correctAnswers.length
                        && correctAnswers[i] == answerOptions[i][numberAnswer-1]){
                    correctCount++;
                }
                else{
                    wrongCount++;
                }

            }
            else{
                wrongCount++;
            }

            System.out.println();
        }

        System.out.println("Результат: правильно " + correctCount + ", неправельно " + wrongCount);

    }
}