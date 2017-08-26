package animals.threatAnimals;

import animals.Animal;

/**
 * Created by 20305 on 13.08.2017.
 */
public enum ThreatAnimals {
    FOX(new Fox()),
    WOLF(new Wolf());

    private Animal animal;

    ThreatAnimals(Animal animal){
        this.animal = animal;
    }
}
