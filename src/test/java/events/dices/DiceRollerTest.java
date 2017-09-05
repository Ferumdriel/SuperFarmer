package events.dices;

import animals.dictionary.FarmAnimals;
import farm.Farm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 20305 on 26.08.2017.
 */
public class DiceRollerTest {
    Farm farm;
    DiceRoller diceRoller;
    @Before
    public void setUp() throws Exception {
        farm = new Farm();
        diceRoller = new DiceRoller(farm);
    }

    @Test
    public void givenEmptyFarmAddZeroAnimalsWhenRewardedWithDifferentAnimals(){
        diceRoller.giveRewards(new FarmAnimals[] {FarmAnimals.RABBIT, FarmAnimals.SHEEP});
        assertEquals(0, farm.getAmountOfBredAnimals(FarmAnimals.RABBIT));
        assertEquals(0, farm.getAmountOfBredAnimals(FarmAnimals.SHEEP));
    }

    @Test
    public void givenEmptyFarmAddAnimalsWhenRewardedWithSameAnimals(){
        diceRoller.giveRewards(new FarmAnimals[] {FarmAnimals.RABBIT, FarmAnimals.RABBIT});
        assertEquals(1, farm.getAmountOfBredAnimals(FarmAnimals.RABBIT));
        assertEquals(0, farm.getAmountOfBredAnimals(FarmAnimals.SHEEP));
    }

    @Test
    public void givenSomeAnimalsAddExtraAnimalsWhenRolled(){
        farm.addAnimal(FarmAnimals.RABBIT, 4);
        farm.addAnimal(FarmAnimals.COW, 3);
        diceRoller.giveRewards(new FarmAnimals[] {FarmAnimals.RABBIT, FarmAnimals.COW});
        assertEquals(6, farm.getAmountOfBredAnimals(FarmAnimals.RABBIT));
        assertEquals(5, farm.getAmountOfBredAnimals(FarmAnimals.COW));
    }

    @Test
    public void givenSequenceOfRewardsAddExtraAnimals(){
        diceRoller.giveRewards(new FarmAnimals[] {FarmAnimals.RABBIT, FarmAnimals.RABBIT});
        assertEquals(1, farm.getAmountOfBredAnimals(FarmAnimals.RABBIT));
        diceRoller.giveRewards(new FarmAnimals[] {FarmAnimals.RABBIT, FarmAnimals.RABBIT});
        assertEquals(2, farm.getAmountOfBredAnimals(FarmAnimals.RABBIT));
        diceRoller.giveRewards(new FarmAnimals[] {FarmAnimals.RABBIT, FarmAnimals.RABBIT});
        assertEquals(4, farm.getAmountOfBredAnimals(FarmAnimals.RABBIT));
        diceRoller.giveRewards(new FarmAnimals[] {FarmAnimals.RABBIT, FarmAnimals.RABBIT});
        assertEquals(7, farm.getAmountOfBredAnimals(FarmAnimals.RABBIT));
    }

}