package animals;

import animals.dictionary.FarmAnimals;
import events.trading.exchangeRules.ExchangeRules;

/**
 * Created by 20305 on 12.08.2017.
 */
public abstract class Animal implements Comparable<Animal>{
    private String name;
    private ExchangeRules<FarmAnimals> exchangeRules;
    protected boolean friendly = true;
    protected boolean fragile = true;
    private int id;
    private static int nextId = 1;

    public Animal(){
        name = getClass().getSimpleName();
        exchangeRules = new ExchangeRules<>();
        setExchangeRules();
        id = nextId;
        nextId++;
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

    @Override
    public int compareTo(Animal o) {
        if(id > o.id){
            return 1;
        }else if(id < o.id){
            return -1;
        }else return 0;
    }
}
