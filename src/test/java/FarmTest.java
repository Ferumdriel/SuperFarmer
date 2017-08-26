import animals.farmAnimals.FarmAnimals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by 20305 on 13.08.2017.
 */
public class FarmTest {
    Farm farm;

    @Before
    public void setUp() throws Exception {
        farm = new Farm();
    }

    @Test
    public void whenInstantiatedThenAnimalsAreNotNull(){
        Assert.assertNotNull(farm.getFarmAnimals().get(FarmAnimals.SHEEP));
    }

    @Test
    public void tradeAnimal() throws Exception {
        farm.addAnimal(FarmAnimals.RABBIT, 6);
        farm.tradeAnimal(FarmAnimals.RABBIT, FarmAnimals.SHEEP);
        Assert.assertEquals(1, farm.getAmountOfBredAnimals(FarmAnimals.SHEEP));
        Assert.assertEquals(0, farm.getAmountOfBredAnimals(FarmAnimals.RABBIT));
    }

}