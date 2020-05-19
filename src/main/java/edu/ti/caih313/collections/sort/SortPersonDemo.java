package edu.ti.caih313.collections.sort;

import edu.ti.caih313.collections.dataobj.Name;
import edu.ti.caih313.collections.dataobj.Person;
import edu.ti.caih313.collections.dataobj.PersonSortable;
import edu.ti.caih313.collections.demo.PrintGeneric;

import java.util.*;

public class SortPersonDemo {

    public static void main(String... args) {
        PersonSortable personArray[] = {
                new PersonSortable(new Name("John", "Smith"), Person.Gender.MALE, 24),
                new PersonSortable(new Name("Karl", "Ng"), Person.Gender.MALE, 27),
                new PersonSortable(new Name("Jessie", "Smith"), Person.Gender.FEMALE, 24),
                new PersonSortable(new Name("Sara", "Rich"), Person.Gender.FEMALE, 36),
                new PersonSortable(new Name("Bob", "Smith"), Person.Gender.MALE, 27),
                new PersonSortable(new Name("Jane", "Doe"), Person.Gender.FEMALE, 40),
                new PersonSortable(new Name("Tony", "Stark"), Person.Gender.MALE, 18),
                new PersonSortable(new Name("Bo", "Peep"), Person.Gender.MALE, 37)
        };

        List<PersonSortable> personList = Arrays.asList(personArray);
        PrintGeneric<PersonSortable> sortPersonDemo = new PrintGeneric<>();

        Comparator<Person> sortPerson = new Comparator<Person>() {
            @Override
            public int compare(Person person, Person otherPerson) {
                int compare;
                if (person.getAge() > otherPerson.getAge()) {
                    compare = 1;
                } else if (person.getAge() < otherPerson.getAge()) {
                    compare = -1;
                } else {
                    if (person.getGender() != otherPerson.getGender()) {
                        switch (person.getGender()) {
                            case FEMALE:
                                compare = -1;
                                break;
                            case MALE:
                                compare = 1;
                                break;
                            default:
                                compare = 0;
                        }
                    } else {
                        compare = person.getName().getLastName().compareTo(otherPerson.getName().getLastName());
                        if (compare == 0) {
                            compare = person.getName().getFirstName().compareTo(otherPerson.getName().getFirstName());
                        }
                    }}
                    return compare;
            }
        };
        Collections.sort(personList, sortPerson);
        System.out.println("\n");
        System.out.println("People sorted by age (youngest first), gender (female first), and then by name (alphabetically): ");
        sortPersonDemo.printCollection(personList);
    }
}
