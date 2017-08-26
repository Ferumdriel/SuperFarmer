package animals.farmAnimals;

import animals.Animal;

/**
 * Created by 20305 on 12.08.2017.
 */
public class Rabbit extends Animal {

    protected void setExchangeRules() {
        setNextExchangeRule(FarmAnimals.SHEEP, 6, 1);
    }
}
