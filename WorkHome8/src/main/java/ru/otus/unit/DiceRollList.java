package ru.otus.unit;

import ru.otus.game.Dice;

import java.util.ArrayList;
import java.util.List;

public class DiceRollList implements Dice {

    private List<Integer> results = new ArrayList<>();
    private int currentI = 0;

    public void Add(int result){

        results.add(result);
    }

    @Override
    public int roll() {
        int result = 0;
        if(results.size()>0){
            result = results.get(currentI);
            currentI++;
            if(currentI == results.size()){
                currentI = 0;
            }
        }
        return result;
    }
}
