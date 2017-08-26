package animals.farmAnimals;

import animals.Animal;
import animals.dictionary.FarmAnimals;
import animals.dictionary.ViableAnimals;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 20305 on 26.08.2017.
 */
public class RabbitTest {
    Animal rabbit;
    @Before
    public void setUp() throws Exception {
        rabbit = ViableAnimals.getAnimal(FarmAnimals.RABBIT);
    }

    @Test
    public void givenExchangeRuleReturnProperExchangeCost(){
        assertEquals(6, rabbit.getExchangeCost(FarmAnimals.SHEEP));
    }
}