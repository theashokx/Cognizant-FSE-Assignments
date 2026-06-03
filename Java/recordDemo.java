import java.util.*;
import java.util.stream.*;

record Person(String name, int age) {}

class recordDemo {
    public static void main(String[] args) {

        List<Person> people = List.of(
            new Person("Shashi", 21),
            new Person("Tapan", 18),
            new Person("Srinith", 22),
            new Person("Dasaradh", 19),
            new Person("Ruchir", 23)
        );

        System.out.println("All Persons:");
        people.forEach(System.out::println);

        System.out.println("\nPersons with age > 20:");

        people.stream()
              .filter(p -> p.age() > 20)
              .forEach(System.out::println);
    }
}