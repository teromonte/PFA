package examples;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    public enum Sex {MALE, FEMALE}

    String name;
    LocalDate birthday;
    Sex gender;

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public String getEmailAddress() {
        return name + "@femto-st.fr";
    }

    public Sex getGender() {
        return gender;
    }

    public void printPerson() {
        System.out.println(name + ", aged " + getAge());
    }

    Person(String name_0, String birthday_as_string, boolean is_male) {
        name = name_0;
        birthday = LocalDate.parse(birthday_as_string);
        gender = is_male ? Sex.MALE : Sex.FEMALE;
    }
}
