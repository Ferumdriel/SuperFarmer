package events.dices;
import animals.dictionary.FarmAnimals;
import animals.dictionary.ViableAnimals;
import events.Event;
import farm.Farm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 20305 on 26.08.2017.
 */
public class DiceRoller implements Event {
    private Farm farm;
    private Dice[] dices;

    public DiceRoller(Farm farm){
        this.farm = farm;
        dices = new Dice[] {new YellowDice(), new RedDice()};
    }

    @Override
    public void performEvent() {
        rollTheDice();
    }

    public void rollTheDice(){
        System.out.println("Rolling the dice");
        FarmAnimals[] rewards = new FarmAnimals[dices.length];
        for(int i = 0; i < dices.length; i++){
            rewards[i] = dices[i].roll();
            System.out.println("You threw " + ViableAnimals.getAnimal(rewards[i]) + " with " + dices[i]);
        }
        giveRewards(rewards);
        processThreatAttack(rewards);
    }

    public void processThreatAttack(FarmAnimals[] rewards){
        for (FarmAnimals reward : rewards) {
            if (reward.equals(FarmAnimals.FOX)) {
                foxAttack();
            } else if (reward.equals(FarmAnimals.WOLF)) {
                wolfAttack();
            }
        }
    }

    private void foxAttack(){
        System.out.println("Oh no. You were attacked by Fox");
        if(farm.getAmountOfBredAnimals(FarmAnimals.SMALLDOG) > 0) {
            System.out.println("Your dog fought brave but it paid for your chickens with his life. RIP in peace Doggo.");
        }else{
            farm.addAnimal(FarmAnimals.RABBIT, -farm.getAmountOfBredAnimals(FarmAnimals.RABBIT));
        }
    }

    private void wolfAttack(){
        System.out.println("Oh no. You were attacked by Big Bad Wolf");
        if(farm.getAmountOfBredAnimals(FarmAnimals.BIGDOG) > 0) {
            System.out.println("Your dog fought brave but it paid for your chickens with his life. RIP in peace Big Doggo.");
        }else{
            farm.getFarmAnimals().forEach((bredAnimal, zero) ->{
                if(bredAnimal.isFragile()){
                    farm.getFarmAnimals().put(bredAnimal, 0);
                }
            });
        }
    }

    public void giveRewards(FarmAnimals[] rewards){ //FIXME Seems like it doesn't add rewards properly
        Map<FarmAnimals, Integer> rewardCounter = new HashMap<>();
        rewardCounter = countPositiveRewards(rewardCounter, rewards);
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
