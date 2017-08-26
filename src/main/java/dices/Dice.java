package dices;

import animals.dictionary.FarmAnimals;

import java.util.Map;
import java.util.Random;

/**
 * Created by 20305 on 26.08.2017.
 */
public abstract class Dice {

    public FarmAnimals roll(){
        return getResult(rollTheDice());
    }

    private int rollTheDice(){
        Random r = new Random();
        return r.nextInt(12);
    }

    public abstract FarmAnimals getResult(int rollResult);

    public String toString(){
        return getClass().getSimpleName();
    }
}
