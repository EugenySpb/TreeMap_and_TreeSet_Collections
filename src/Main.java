import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Volan", "De Mort", 72));
        people.add(new Person("Harry", "Potter", 20));
        people.add(new Person("Draco", "Malfoy", 19));
        people.add(new Person("Hermione", "Granger", 21));
        people.add(new Person("Ronald", "Weasley", 22));
        people.add(new Person("Bartemius", "Crouch Jr", 35));
        people.add(new Person("Albus", "Percival Wulfric Brian Dumbledore", 115));
        people.add(new Person("Nikolay", "Rimsky-Korsakov", 65));
        people.add(new Person("Nikolay", "Miklukho-Maclay", 45));
        System.out.println(people.toString().replaceAll("^\\[|]$", ""));
        System.out.println();

        Comparator<Person> comparator = (o1, o2) -> {
            int maxSurnameWords = 2;
            String[] o1SurnameWords = o1.getSurname().split("\\s|-");
            String[] o2SurnameWords = o2.getSurname().split("\\s|-");
            int o1SurnameWordsCount = o1SurnameWords.length;
            int o2SurnameWordsCount = o2SurnameWords.length;

            if (o1SurnameWordsCount >= maxSurnameWords && o2SurnameWordsCount >= maxSurnameWords) {
                // Если фамилии одинаковые, сравниваем по возрасту
                return Integer.compare(o2.getAge(), o1.getAge());
            }

            int surnameLengthComp = Integer.compare(o2SurnameWordsCount, o1SurnameWordsCount);
            if (surnameLengthComp != 0) { // Сравниваем по длине фамилии
                return surnameLengthComp;
            } else {
                return Integer.compare(o2.getAge(), o1.getAge()); // Сравниваем по возрасту.
            }
        };

        Collections.sort(people, comparator);
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
