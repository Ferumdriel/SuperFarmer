package farm;

import animals.Animal;
import animals.dictionary.FarmAnimals;
import animals.dictionary.ViableAnimals;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 20305 on 13.08.2017.
 */
public class Farm {
    private Map<Animal, Integer> farmAnimals = new TreeMap<>();

    public Farm(){
        loadFarmAnimals();
    }

    public void tradeAnimal(FarmAnimals animalToSell, FarmAnimals animalToBuy){
        if(isTradePossible(animalToSell, animalToBuy)){
            if(isTradeAffordable(animalToSell, animalToBuy)){
                finalizeTrade(animalToSell, animalToBuy);
            }
        }else{
            System.out.println("Trade is not possible");
        }
    }

    private void finalizeTrade(FarmAnimals animalToSell, FarmAnimals animalToBuy){
        farmAnimals.put(ViableAnimals.getAnimal(animalToSell), calcAmountAfterSell(animalToSell, animalToBuy));
        farmAnimals.put(ViableAnimals.getAnimal(animalToBuy), calcAmountAfterBuy(animalToSell, animalToBuy));
    }

    private int calcAmountAfterSell(FarmAnimals animalToSell, FarmAnimals animalToBuy){
        return farmAnimals.get(ViableAnimals.getAnimal(animalToSell)) - this.getExchangeCost(animalToSell,animalToBuy);
    }

    private int calcAmountAfterBuy(FarmAnimals animalToSell, FarmAnimals animalToBuy){
        return farmAnimals.get(ViableAnimals.getAnimal(animalToBuy)) + getExchangeGain(animalToSell,animalToBuy);
    }

    public void addAnimal(FarmAnimals animal, int count){
        if(!farmAnimals.containsKey(ViableAnimals.getAnimal(animal))){
            farmAnimals.put(ViableAnimals.getAnimal(animal), count);
        }else{
            farmAnimals.put(ViableAnimals.getAnimal(animal), farmAnimals.get(ViableAnimals.getAnimal(animal)) + count);
        }

    }

    private boolean isTradePossible(FarmAnimals animalToSell, FarmAnimals animalToBuy){
        return ViableAnimals.getAnimal(animalToSell).getExchangeRules().getViableExchanges().containsKey(animalToBuy);
    }

    private boolean isTradeAffordable(FarmAnimals animalToSell, FarmAnimals animalToBuy){
        return getAmountOfBredAnimals(animalToSell) >= getExchangeCost(animalToSell, animalToBuy);
    }

    private int getExchangeCost(FarmAnimals animalToSell, FarmAnimals animalToBuy)/* throws MissingRuleException*/{
        return ViableAnimals.getAnimal(animalToSell).getExchangeCost(animalToBuy);
    }

    private int getExchangeGain(FarmAnimals animalToSell, FarmAnimals animalToBuy)/* throws MissingRuleException*/{
        return ViableAnimals.getAnimal(animalToSell).getExchangeGain(animalToBuy);
    }

    private void loadFarmAnimals(){
        addAnimal(FarmAnimals.RABBIT, 0);
        addAnimal(FarmAnimals.SHEEP, 0);
        addAnimal(FarmAnimals.PIG, 0);
        addAnimal(FarmAnimals.COW,0 );
        addAnimal(FarmAnimals.HORSE,0);
        addAnimal(FarmAnimals.SMALLDOG,0);
        addAnimal(FarmAnimals.BIGDOG,0);
    }

    public Map<Animal, Integer> getFarmAnimals() {
        return farmAnimals;
    }

    public int getAmountOfBredAnimals(FarmAnimals animal){
        return farmAnimals.get(ViableAnimals.getAnimal(animal));
    }

    public void printCurrentFarmStatus(){
        farmAnimals.forEach((animal, animalAmount) -> System.out.println("You have " + animalAmount + "x " + animal));
    }
}
