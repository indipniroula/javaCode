package simpleoop.simpleinterfaces.peoplecompare;

public class ForenameComparator implements PersonComparator{
    public int compareTo(Person p1, Person p2) {

        // A lot easier is to use compareTo method on strings.
        // e.g return p1.getForename.compareTo(p2.getForename);
        int answer = 0;
        if (p1.getForename().equals(p2.getForename())) {
            return 0;
        } else {
            int bound = Math.min(p1.getForename().length(), p2.getForename().length());
            for (int i = 0; i < bound; i++) {
                if (p1.getForename().charAt(i) < p2.getForename().charAt(i)) {
                    answer = -1;
                } else {
                    answer = 1;
                }
            }
        }
        return answer;
    }
}
