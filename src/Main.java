import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Volan", "De Mort", 72));
        people.add(new Person("Harry", "Potter", 12));
        people.add(new Person("Draco", "Malfoy", 15));
        people.add(new Person("Hermione", "Granger", 13));
        people.add(new Person("Ronald", "Weasley", 22));
        people.add(new Person("Bartemius", "Crouch Jr", 35));
        people.add(new Person("Albus", "Percival Wulfric Brian Dumbledore", 115));
        people.add(new Person("Nikolay", "Rimsky-Korsakov", 65));
        people.add(new Person("Nikolay", "Miklukho-Maclay", 45));
        System.out.println(people.toString().replaceAll("^\\[|]$", ""));
        System.out.println();

        people.removeIf(person -> person.getAge() < 18);

        ComparisonPeople comparator = new ComparisonPeople(2);
        Collections.sort(people, comparator);
        people.forEach(System.out::println);
    }
}
