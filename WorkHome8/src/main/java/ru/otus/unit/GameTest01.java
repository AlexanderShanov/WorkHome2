package ru.otus.unit;

import ru.otus.assertions.Assertions;
import ru.otus.game.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class GameTest01 {

    private Game game;
    private  DiceRollList dice;
    public GameTest01(){
        dice = new DiceRollList();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        game = new Game(dice, winnerPrinter);
    }

    public void testFirstBigSecond(){
        String scenario = "V2. Тест результатов выброса кубика первый больше второго";
        try {
            String expected ="Победитель: Вася";
            String actualStream;
            String[] actualLines;
            try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream))
            {
                PrintStream outConsole = System.out;
                System.setOut(printStream);
                dice.Add(3);
                dice.Add(2);
                game.playGame(new Player("Вася"), new Player("Игорь"));
                System.setOut(outConsole);
                actualStream = outputStream.toString();
                actualLines = actualStream.split("\r\n");
            }
            Assertions.assertEquals(1, actualLines.length);
            Assertions.assertEquals(expected, actualLines[0]);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testSecondBidFisrt() {
        String scenario = "V3. Тест результатов выброса кубика второй больше первого";
        try {
            String expected = "Победитель: Игорь";
            String actualStream;
            String[] actualLines;
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                 PrintStream printStream = new PrintStream(outputStream)) {
                PrintStream outConsole = System.out;
                System.setOut(printStream);
                dice.Add(2);
                dice.Add(3);
                game.playGame(new Player("Вася"), new Player("Игорь"));
                System.setOut(outConsole);
                actualStream = outputStream.toString();
                actualLines = actualStream.split("\r\n");
            }
            Assertions.assertEquals(1, actualLines.length);
            Assertions.assertEquals(expected, actualLines[0]);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testFisrtEqualsSecond(){
        String scenario = "V4. Тест результатов выброса кубика первый равен второму";
        try {
            String expected ="Ничья";
            String actualStream;
            String[] actualLines;
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                 PrintStream printStream = new PrintStream(outputStream)) {
                PrintStream outConsole = System.out;
                System.setOut(printStream);
                dice.Add(4);
                dice.Add(4);
                game.playGame(new Player("Вася"), new Player("Игорь"));
                System.setOut(outConsole);
                actualStream = outputStream.toString();
                actualLines = actualStream.split("\r\n");
            }
            Assertions.assertEquals(1, actualLines.length);
            Assertions.assertEquals(expected, actualLines[0]);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }


}
