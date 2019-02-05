package simpleoop.simpleinterfaces.peoplecompare;

public class PhoneNumComparator implements PersonComparator {

    public int compareTo(Person p1, Person p2) {
        int answer = 0;
        if (p1.getPhoneNum().equals(p2.getPhoneNum())) {
            return 0;
        } else {
            int bound = Math.min(p1.getPhoneNum().length(), p2.getPhoneNum().length());
            for (int i = 0; i < bound; i++) {
                if (p1.getPhoneNum().charAt(i) < p2.getPhoneNum().charAt(i)) {
                    answer = -1;
                } else {
                    answer = 1;
                }
            }
        }
        return answer;
    }

}
