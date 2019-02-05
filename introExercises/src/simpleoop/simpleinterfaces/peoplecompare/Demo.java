package simpleoop.simpleinterfaces.peoplecompare;

import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        ForenameComparator f1 = new ForenameComparator();
        SurnameComparator f2 = new SurnameComparator();
        int num = f2.compareTo(new Person("b", "ABCD", "123"), new Person("a", "ABCA", "123"));
        System.out.println(num);
    }

    public static Person findMin(Set<Person> people,
                                 PersonComparator comparator){
        return null;
    }
}
