import java.util.Comparator;

public class ComparisonPeople implements Comparator<Person> {
    private final int maxSurnameWords;

    public ComparisonPeople(int maxSurnameWords) {
        this.maxSurnameWords = maxSurnameWords;
    }

    @Override
    public int compare(Person o1, Person o2) {
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
    }
}