package simpleoop.simpleinterfaces.peoplecompare;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {

        Set<Person> people = new HashSet<>();
        people.add(new Person("Partridge", "Alan", "12345"));
        people.add(new Person("Surname", "Judith", "12354"));
        people.add(new Person("Surname", "Peter", "14253"));
        people.add(new Person("Field", "Tony", "61432"));
        people.add(new Person("Donaldson", "Minty", "25142"));
        people.add(new Person("Donaldson", "Jekyll", "25142"));
        people.add(new Person("Donaldson", "Jekyll", "00000"));

        System.out.println(findMin(people, new SurnameComparator()));


        //TwoTier comparator and three tier using compostion.
        TwoTieredComparator surnameForename = new TwoTieredComparator(new SurnameComparator(), new ForenameComparator());
        TwoTieredComparator threeTierComparator = new TwoTieredComparator(new SurnameComparator(), new TwoTieredComparator(new ForenameComparator(), new PhoneNumComparator()));


    }

    public static Person findMin(Set<Person> people,
                                 PersonComparator comparator){
        Person minPerson = null;
        for (Person p : people) {
            if (minPerson == null || comparator.compareTo(p, minPerson) == -1) {
                minPerson = p;
            }
        }
        return minPerson;
    }
}
