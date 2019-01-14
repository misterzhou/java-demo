package org.guojing.test.newfeature.java8;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created at: 2017-06-11 19:26
 *
 * @author guojing
 *
 * @since 1.8+
 */
public class LambdaDemo {

    public static void printPersons1(List<Person> roster, CheckPerson checkPerson) {
        for (Person p : roster) {
            if (checkPerson.test(p)) {
                p.toString();
            }
        }
    }

    public static void printPersons2(List<Person> roster, Predicate<Person> checker) {
        for (Person p : roster) {
            if (checker.test(p)) {
                p.toString();
            }
        }
    }

    public static void printPersons3(List<Person> roster, Predicate<Person> checker, Consumer<Person> consumer) {
        for (Person p : roster) {
            if (checker.test(p)) {
                consumer.accept(p);
            }
        }
    }

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(SOURCE sourceCollection, Supplier<DEST> collectionFactory) {
        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        Person kobe = new Person("kobe", LocalDate.of(1985, 6, 1), Person.Sex.MALE, "kobe@nba.com");
        Person james = new Person("james", LocalDate.of(1980, 5, 1), Person.Sex.MALE, "james@nba.com");
        List<Person> persons = Arrays.asList(kobe, james);
        LambdaDemo.printPersons1(persons, (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
        LambdaDemo.printPersons1(persons, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 30);

        LambdaDemo.printPersons2(persons, person -> person.getGender() == Person.Sex.MALE && person.getAge() >= 30);

        LambdaDemo.printPersons3(persons, person -> person.getGender() == Person.Sex.MALE, person -> System.out.println(person));

        persons.stream().filter(person -> person.getGender() == Person.Sex.MALE).map(person -> person.getEmailAddress()).forEach(email -> System.out.println(email));

        Arrays.sort(persons.toArray(new Person[persons.size()]), Person::compareByAge);

    }

}
