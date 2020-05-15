package edu.ti.caih313.collections.dataobj;

public class PersonSortable extends Person implements Comparable<PersonSortable> {
    public PersonSortable(Name name, Gender gender, double age) {
        super(name, gender);
        super.setAge(age);
    }

    @Override
    public int compareTo(PersonSortable otherPerson) {
        int compare = getName().getLastName().compareTo(otherPerson.getName().getLastName());
           if (compare == 0) {
             compare = getName().getFirstName().compareTo(otherPerson.getName().getFirstName());
        }return compare;
    }
}
