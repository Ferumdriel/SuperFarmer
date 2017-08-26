import animals.Animal;
import animals.dictionary.FarmAnimals;
import animals.farmAnimals.Rabbit;
import animals.farmAnimals.Sheep;
import animals.dictionary.ViableAnimals;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 20305 on 13.08.2017.
 */
public class Testowy {

    public static void main(String[] args){
        Map<Animal, Integer> mapa = new HashMap<>();
        Animal rabbit = new Rabbit();
        System.out.println(rabbit.getExchangeRules());
        Animal sheep = new Sheep();
        System.out.println(sheep.getExchangeRules().getExchangeCost(FarmAnimals.RABBIT));
        Animal pig = ViableAnimals.animals.get(FarmAnimals.PIG);
        System.out.println(sheep.getExchangeRules().getExchangeCost(FarmAnimals.RABBIT));
//        Animal sheep = new Sheep();
//        System.out.println(sheep);

//        mapa.put(FarmAnimals.RABBIT.getAnimal(), 10);
//        System.out.println(mapa.get(rabbit));
//        System.out.println(mapa.get(FarmAnimals.RABBIT.getAnimal()));

    }
}
