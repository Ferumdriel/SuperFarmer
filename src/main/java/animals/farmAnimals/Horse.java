package animals.farmAnimals;

import animals.Animal;

/**
 * Created by 20305 on 13.08.2017.
 */
public class Horse extends Animal {

    public Horse() {
        super();
        fragile = false;
    }

    protected boolean isTradePossible() {
        return false;
    }

    protected void setExchangeRules() {

    }
}
