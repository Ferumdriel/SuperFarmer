package animals;

import animals.farmAnimals.FarmAnimals;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 20305 on 12.08.2017.
 */
public abstract class Animal{
    private String name;
    private ExchangeRules<FarmAnimals> exchangeRules;

    public Animal(){
        name = getClass().getSimpleName();
        setExchangeRules();
    }

    protected abstract void setExchangeRules();

    protected void setNextExchangeRule(FarmAnimals animal, int exchangeCost, int exchangeGain){
        exchangeRules.addRule(animal, exchangeCost, exchangeGain);
    }

    public int getExchangeCost(FarmAnimals animal){
        return getExchangeRules().getExchangeCost(animal);
    }

    public int getExchangeGain(FarmAnimals animal){
        return getExchangeRules().getExchangeGain(animal);
    }

    public ExchangeRules<FarmAnimals> getExchangeRules() {
        return exchangeRules;
    }

}
