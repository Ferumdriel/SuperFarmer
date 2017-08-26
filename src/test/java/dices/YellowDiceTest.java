package dices;

import animals.dictionary.FarmAnimals;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 20305 on 26.08.2017.
 */
public class YellowDiceTest {
    Dice dice;
    @Before
    public void setUp() throws Exception {
        dice = new YellowDice();
    }

    @Test
    public void givenSpecificRollReturnProperAnimal(){
        assertEquals(FarmAnimals.RABBIT, dice.getResult(5));
        assertEquals(FarmAnimals.SHEEP, dice.getResult(6));
        assertEquals(FarmAnimals.PIG, dice.getResult(9));
    }

}