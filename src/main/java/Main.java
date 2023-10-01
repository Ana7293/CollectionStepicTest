import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("BMW", 1);
        Car car2 = new Car("BMW", 1);
        car2 = car1;
        car2.setNumber(5);
        System.out.println(car1.getNumber());
        System.out.println(true);
        String brand = "BMW";
        System.out.println(Objects.equals(car1.getBrand(), brand));

        System.out.println(true);
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());


    Set<Integer> numbers = new TreeSet<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -o1.compareTo(o2);
        }
    });
 for(
    int i = 0;
    i< 100;i++)

    {
        numbers.add((int) (Math.random() * 10));
    }
 for(
    int number:numbers)

    {
        System.out.println(number);
    }
}
}
