
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;

public class CarListTest {
    private CarList carList;

    @BeforeEach
    public void setUp() throws Exception {
      //  carList = new CarArrayList();            //для АррайЛист
        carList = new CarLinkedList();            //для ЛинкедЛист
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        Assertions.assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        Assertions.assertTrue(carList.removeAt(5));
        Assertions.assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("Toyota", 15);
        carList.add(car);
        Assertions.assertEquals(101, carList.size());
        Assertions.assertTrue(carList.remove(car));
        Assertions.assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Toyota", 15);
        Assertions.assertFalse(carList.remove(car));
        Assertions.assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        Assertions.assertEquals(0, carList.size());
    }

    @Test
    public void whenIndexOutOfBoundsThenThrownException() {
        double extented = 1;
        int result = 0;
        try {
            carList.get(100);
        } catch (Exception e){
            result = 1;
        }

    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        Assertions.assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle() {
        Car car = new Car("BMW", 1);
        carList.add(car, 50);
        Car carFromList = carList.get(50);
        Assertions.assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirstPosition() {
        Car car = new Car("BMW", 1);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        Assertions.assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("BMW", 1);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        Assertions.assertEquals("BMW", carFromList.getBrand());
    }
}