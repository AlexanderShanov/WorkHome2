package ru.otus.unit;

import ru.otus.assertions.Assertions;
import ru.otus.game.Dice;
import ru.otus.game.DiceImpl;

import java.util.ArrayList;
import java.util.List;

public class DiceTest01 {
    private final Dice dice = new DiceImpl();

    public void testDiceRangeCheck(){
        String scenario = "V1. Тест результатов выброса кубика на вхождение в диапозон 1-6";
        try {
            for (int i = 0; i<10; i++){
                List<Integer> expected = new ArrayList<>();
                expected.add(1);
                expected.add(2);
                expected.add(3);
                expected.add(4);
                expected.add(5);
                expected.add(6);
                int actual = dice.roll();
                Assertions.assertCheckFunction(expected, actual);
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
