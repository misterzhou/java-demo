package org.guojing.test.newfeature.java8;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created at: 2017-06-11 19:27
 *
 * @author guojing
 */
public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person() {
    }

    public Person(String name, LocalDate birthday, Sex gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this(name, birthday, gender);
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Person setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Sex getGender() {
        return gender;
    }

    public Person setGender(Sex gender) {
        this.gender = gender;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Person setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", gender=").append(gender);
        sb.append(", emailAddress='").append(emailAddress).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
