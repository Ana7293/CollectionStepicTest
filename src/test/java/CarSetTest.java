import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;


public class CarSetTest {
    private CarSet carSet;

    @Before
    public void setUp() throws Exception {
        carSet = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdd3SimilarObjectsThenSizeIncreaseBy1() {
        Assertions.assertEquals(100, carSet.size());
        Assertions.assertTrue(carSet.add(new Car("BMW", 10)));
        Assertions.assertFalse(carSet.add(new Car("BMW", 10)));
        Assertions.assertFalse(carSet.add(new Car("BMW", 10)));
        Assertions.assertEquals(101, carSet.size());
    }

    @Test
    public void whenSetClearedThenSize0() {
        carSet.clear();
        Assertions.assertEquals(0, carSet.size());
    }

    @Test
    public void whenElementRemovedThenSizeDecreased() {
        Assertions.assertTrue(carSet.remove(new Car("Brand30", 30)));
        Assertions.assertEquals(99, carSet.size());
        Assertions.assertFalse(carSet.remove(new Car("Brand30", 30)));
        Assertions.assertEquals(99, carSet.size());
    }
}