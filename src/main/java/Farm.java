import animals.farmAnimals.FarmAnimals;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 20305 on 13.08.2017.
 */
public class Farm {
    private Map<FarmAnimals, Integer> farmAnimals = new HashMap<>();

    public Farm(){
        loadFarmAnimals();
    }

    public void tradeAnimal(FarmAnimals animalToSell, FarmAnimals animalToBuy){
        if(isTradePossible(animalToSell, animalToBuy)){
            finalizeTrade(animalToSell, animalToBuy);
        }
    }

    private void finalizeTrade(FarmAnimals animalToSell, FarmAnimals animalToBuy){
        farmAnimals.put(animalToSell, farmAnimals.get(animalToSell) - animalToSell.getAnimal().getExchangeCost(animalToBuy));
        farmAnimals.put(animalToBuy,farmAnimals.get(animalToBuy) + animalToSell.getAnimal().getExchangeGain(animalToBuy));
    }

    void addAnimal(FarmAnimals animal, int count){
        farmAnimals.put(animal, count);
    }

    private boolean isTradePossible(FarmAnimals animalToSell, FarmAnimals animalToBuy){
        return farmAnimals.get(animalToSell) > getExchangeCost(animalToSell, animalToBuy);
    }

    private int getExchangeCost(FarmAnimals animalToSell, FarmAnimals animalToBuy){
        return animalToSell.getAnimal().getExchangeCost(animalToBuy);
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

    public Map<FarmAnimals, Integer> getFarmAnimals() {
        return farmAnimals;
    }

    public int getAmountOfBredAnimals(FarmAnimals animal){
        return farmAnimals.get(animal);
    }
}
