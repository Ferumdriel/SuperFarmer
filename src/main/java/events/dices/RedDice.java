package events.dices;

import animals.dictionary.FarmAnimals;

/**
 * Created by 20305 on 26.08.2017.
 */
public class RedDice extends Dice{

    public FarmAnimals getResult(int rollResult){
        FarmAnimals result;
        if(rollResult <= 5){
            result = FarmAnimals.RABBIT;
        }else if (rollResult > 5 && rollResult <= 8){
            result = FarmAnimals.SHEEP;
        }else if (rollResult == 9){
            result = FarmAnimals.PIG;
        }else if (rollResult == 10){
            result = FarmAnimals.HORSE;
        }else result = FarmAnimals.FOX;
        return result;
    }
}
