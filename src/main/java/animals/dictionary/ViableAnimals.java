package animals.dictionary;

import animals.Animal;
import animals.dictionary.FarmAnimals;
import animals.farmAnimals.*;
import animals.threatAnimals.Fox;
import animals.threatAnimals.Wolf;

import java.util.EnumMap;

/**
 * Created by 20305 on 26.08.2017.
 */
public class ViableAnimals {
    public static EnumMap<FarmAnimals, Animal> animals = createMap();

    private static EnumMap<FarmAnimals, Animal> createMap(){
        EnumMap<FarmAnimals, Animal> tmp = new EnumMap<>(FarmAnimals.class);
        tmp.put(FarmAnimals.RABBIT, new Rabbit());
        tmp.put(FarmAnimals.SHEEP, new Sheep());
        tmp.put(FarmAnimals.PIG, new Pig());
        tmp.put(FarmAnimals.COW, new Cow());
        tmp.put(FarmAnimals.HORSE, new Horse());
        tmp.put(FarmAnimals.SMALLDOG, new SmallDog());
        tmp.put(FarmAnimals.BIGDOG, new BigDog());
        tmp.put(FarmAnimals.FOX, new Fox());
        tmp.put(FarmAnimals.WOLF, new Wolf());
        return tmp;
    }

    public static Animal getAnimal(FarmAnimals animal){
        return animals.get(animal);
    }
}
