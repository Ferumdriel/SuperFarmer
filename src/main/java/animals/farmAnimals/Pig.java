package animals.farmAnimals;

import animals.Animal;
import animals.dictionary.FarmAnimals;

/**
 * Created by 20305 on 13.08.2017.
 */
public class Pig extends Animal{

    protected void setExchangeRules() {
        setNextExchangeRule(FarmAnimals.SHEEP, 1, 2);
        setNextExchangeRule(FarmAnimals.COW, 3, 1);
    }
}
