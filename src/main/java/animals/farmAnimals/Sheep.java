package animals.farmAnimals;

import animals.Animal;
import animals.dictionary.FarmAnimals;

/**
 * Created by 20305 on 12.08.2017.
 */
public class Sheep extends Animal {

    protected void setExchangeRules() {
        setNextExchangeRule(FarmAnimals.RABBIT, 1, 6);
        setNextExchangeRule(FarmAnimals.PIG, 2, 1);
        setNextExchangeRule(FarmAnimals.SMALLDOG, 1, 1);
    }
}
