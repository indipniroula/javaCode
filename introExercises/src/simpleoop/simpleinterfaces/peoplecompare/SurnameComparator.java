package simpleoop.simpleinterfaces.peoplecompare;

public class SurnameComparator implements PersonComparator {
    public int compareTo(Person p1, Person p2) {
        int answer = 0;
        if (p1.getSurname().equals(p2.getSurname())) {
            return 0;
        } else {
            int bound = Math.min(p1.getSurname().length(), p2.getSurname().length());
            for (int i = 0; i < bound; i++) {
                if (p1.getSurname().charAt(i) < p2.getSurname().charAt(i)) {
                    answer = -1;
                } else {
                    answer = 1;
                }
            }
        }
        return answer;  
    }
}
