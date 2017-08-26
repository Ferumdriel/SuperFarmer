package animals.farmAnimals;

import animals.Animal;
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
        sheep = FarmAnimals.SHEEP.getAnimal();
    }

    @Test
    public void whenInstantiatedObjectIsNotNull(){
        assertNotNull(sheep);
    }

}