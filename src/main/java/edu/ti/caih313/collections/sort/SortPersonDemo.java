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
                new PersonSortable(new Name("Jessie", "Smith"), Person.Gender.FEMALE, 32),
                new PersonSortable(new Name("Sara", "Rich"), Person.Gender.FEMALE, 36),
                new PersonSortable(new Name("Bob", "Smith"), Person.Gender.MALE, 28),
                new PersonSortable(new Name("Jane", "Doe"), Person.Gender.FEMALE, 40),
                new PersonSortable(new Name("Tony", "Stark"), Person.Gender.MALE, 18),
                new PersonSortable(new Name("Bo", "Peep"), Person.Gender.MALE, 37)
        };

        List<PersonSortable> personList = Arrays.asList(personArray);
        PrintGeneric<PersonSortable> sortPersonDemo = new PrintGeneric<>();
        //sortPersonDemo.printCollection(personList);

        Collections.sort(personList);
        System.out.print("\n");
        System.out.println("Print people sorted by Name: ");
        sortPersonDemo.printCollection(personList);

        Comparator<Person> personByAge = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if (p1.getAge() != p2.getAge()) {
                    if (p1.getAge() > p2.getAge()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }else{ return 0;}
            }
        };
        Collections.sort(personList, personByAge);
        System.out.println("\n");
        System.out.println("Print people sorted by Age, oldest first: ");
        sortPersonDemo.printCollection(personList);

        Comparator<Person> personByGender = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if (p1.getGender() != p2.getGender()) {
                    if(p1.getGender() == Person.Gender.FEMALE){
                        return -1;
                    }else{
                        return 1;
                    }
                }else {
                    return 0;
                }
            }
        };
        Collections.sort(personList, personByGender);
        System.out.println("\n");
        System.out.println("Print people sorted by Gender, female first: ");
        sortPersonDemo.printCollection(personList);
    }
}
