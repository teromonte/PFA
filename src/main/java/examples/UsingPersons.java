package examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class UsingPersons {
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) if (p.getAge() >= age) p.printPerson();
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            int age = p.getAge();
            if (low <= age && age < high) p.printPerson();
        }
    }

    interface CheckPerson {
        boolean test(Person p);
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) if (tester.test(p)) p.printPerson();
    }

    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) if (tester.test(p)) p.printPerson();
    }

    public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : roster) if (tester.test(p)) block.accept(p);
    }

    public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster)
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
    }

    public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> block) {
        for (X p : source)
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
    }

    //
    public static void main(String[] args) {
        List<Person> roster = new ArrayList<Person>() {{
            add(new Person("Albert", "1922-10-06", true));
            add(new Person("Dylan", "1995-11-19", true));
            add(new Person("Flaubert", "1992-03-06", true));
            add(new Person("JMH", "1960-04-07", true));
            add(new Person("Maeva", "2002-07-12", false));
            add(new Person("Manu", "1973-07-23", true));
            add(new Person("Marise", "1947-11-01", false));
            add(new Person("Marvin", "2001-09-03", true));
            add(new Person("Morgane", "2002-07-12", false));
            add(new Person("Mummy", "1920-09-15", false));
        }};
        class CheckPersonEligibleForSelectiveService implements CheckPerson {
            public boolean test(Person p) {
                int age = p.getAge();
                return p.gender == Person.Sex.MALE && age >= 18 && age <= 25;
            }
        }
        printPersons(roster, new CheckPersonEligibleForSelectiveService());
        printPersons(roster, new CheckPerson() {
            public boolean test(Person p) {
                int age = p.getAge();
                return p.getGender() == Person.Sex.MALE && age >= 18 && age <= 25;
            }
        });

        printPersons(roster, (Person p) -> {
            int age = p.getAge();
            return p.getGender() == Person.Sex.MALE && age >= 18 && age <= 25;
        });

        printPersonsWithPredicate(roster, p -> {
            int age = p.getAge();
            return p.getGender() == Person.Sex.MALE && age >= 18 && age <= 25;
        });

        processPersons(roster, p -> {
            int age = p.getAge();
            return p.getGender() == Person.Sex.MALE && age >= 18 && age <= 25;
        }, Person::printPerson);

        processPersonsWithFunction(roster, p -> {
            int age = p.getAge();
            return p.getGender() == Person.Sex.MALE && age >= 18 && age <= 25;
        }, Person::getEmailAddress, System.out::println);

        processElements(roster, p -> {
            int age = p.getAge();
            return p.getGender() == Person.Sex.MALE && age >= 18 && age <= 25;
        }, Person::getEmailAddress, System.out::println);

        roster.stream().filter(p -> {
            int age = p.getAge();
            return p.getGender() == Person.Sex.MALE && age >= 18 && age <= 25;
        }).map(Person::getEmailAddress).forEach(System.out::println);
    }
}
