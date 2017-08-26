package animals.farmAnimals;

import animals.Animal;
import animals.farmAnimals.*;

/**
 * Created by 20305 on 12.08.2017.
 */
public enum FarmAnimals {
    RABBIT(new Rabbit()),
    SHEEP(new Sheep()),
    PIG(new Pig()),
    COW(new Cow()),
    HORSE(new Horse()),
    SMALLDOG(new SmallDog()),
    BIGDOG(new BigDog());

    private Animal animal;

    FarmAnimals(Animal animal){
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }
}
