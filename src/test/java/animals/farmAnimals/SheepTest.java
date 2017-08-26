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
public class SheepTest {
    Animal sheep;
    @Before
    public void setUp() throws Exception {
        sheep = ViableAnimals.getAnimal(FarmAnimals.SHEEP);
    }

    @Test
    public void whenInstantiatedObjectIsNotNull(){
        assertNotNull(sheep);
    }

    @Test
    public void whenInstantiatedRulesAreSet(){
        assertNotNull(sheep.getExchangeRules());
    }

    @Test
    public void givenAnimalToTradeReturnExchangeCost(){
        assertEquals(1, sheep.getExchangeRules().getExchangeCost(FarmAnimals.RABBIT));
    }

    @Test
    public void givenAnimalToTradeReturnExchangeGain(){
        assertEquals(6, sheep.getExchangeRules().getExchangeGain(FarmAnimals.RABBIT));
    }

}