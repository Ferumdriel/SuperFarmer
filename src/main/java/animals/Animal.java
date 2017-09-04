package animals;

import animals.dictionary.FarmAnimals;

/**
 * Created by 20305 on 12.08.2017.
 */
public abstract class Animal{
    private String name;
    private static ExchangeRules<FarmAnimals> exchangeRules;
    protected boolean friendly = true;
    protected boolean fragile = true;

    public Animal(){
        name = getClass().getSimpleName();
        exchangeRules = new ExchangeRules<>();
        setExchangeRules();
    }

    protected abstract void setExchangeRules();

    protected void setNextExchangeRule(FarmAnimals animal, int exchangeCost, int exchangeGain){
        exchangeRules.addRule(animal, exchangeCost, exchangeGain);
    }

    public int getExchangeCost(FarmAnimals animal){
        return exchangeRules.getExchangeCost(animal);
    }

    public int getExchangeGain(FarmAnimals animal){
        return exchangeRules.getExchangeGain(animal);
    }

    public ExchangeRules<FarmAnimals> getExchangeRules() {
        return exchangeRules;
    }

    public String toString(){
        return this.getClass().getSimpleName();
    }

    public boolean isFriendly(){
        return friendly;
    }

    public boolean isFragile() {
        return fragile;
    }
}
