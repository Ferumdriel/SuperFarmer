package animals.farmAnimals;

import animals.Animal;
import animals.dictionary.FarmAnimals;

/**
 * Created by 20305 on 13.08.2017.
 */
public class Cow extends Animal{


    protected void setExchangeRules() {
        setNextExchangeRule(FarmAnimals.PIG, 1, 3);
        setNextExchangeRule(FarmAnimals.HORSE, 2, 1);
        setNextExchangeRule(FarmAnimals.BIGDOG, 1, 1);
    }
}
