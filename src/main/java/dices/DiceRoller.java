package dices;
import animals.dictionary.FarmAnimals;
import animals.dictionary.ViableAnimals;
import farm.Farm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 20305 on 26.08.2017.
 */
public class DiceRoller {
    private Farm farm;
    private Dice[] dices;

    public DiceRoller(Farm farm){
        this.farm = farm;
        dices = new Dice[] {new YellowDice(), new RedDice()};
    }

    public void rollTheDice(){
        FarmAnimals[] rewards = new FarmAnimals[dices.length];
        for(int i = 0; i < dices.length; i++){
            rewards[i] = dices[i].roll();
            System.out.println("You threw " + ViableAnimals.getAnimal(rewards[i]) + " with " + dices[i]);
        }
        giveRewards(rewards);
    }

    public void giveRewards(FarmAnimals[] rewards){
        Map<FarmAnimals, Integer> rewardCounter = new HashMap<>();
        rewardCounter = countPositiveRewards(rewardCounter, rewards);
        for (FarmAnimals reward : rewards) {
            if (reward.equals(FarmAnimals.FOX)) {
                System.out.println("Oh no. You were attacked by Fox");
            } else if (reward.equals(FarmAnimals.WOLF)) {
                System.out.println("Oh no. You were attacked by BigBadWolf");
            }
        }
        rewardCounter.forEach((rolledAnimal, timesRolled) ->
            farm.addAnimal(rolledAnimal, (farm.getAmountOfBredAnimals(rolledAnimal) + timesRolled)/2)
        );
    }

    private Map<FarmAnimals, Integer> countPositiveRewards(Map<FarmAnimals, Integer> rewardCounter, FarmAnimals[] rewards) {
        for (FarmAnimals reward : rewards) {
            if (ViableAnimals.getAnimal(reward).isFriendly()) {
                rewardCounter = increaseCurrentAnimalRewardByOne(rewardCounter, reward);
            }
        }
        return rewardCounter;
    }

    private Map<FarmAnimals, Integer> increaseCurrentAnimalRewardByOne(Map<FarmAnimals, Integer> rewardCounter, FarmAnimals reward){
        if (rewardCounter.containsKey(reward)) {
            rewardCounter.put(reward, rewardCounter.get(reward) + 1);
        } else rewardCounter.put(reward, 1);
        return rewardCounter;
    }



}
