import java.util.HashSet;
import java.util.Set;

public class ProgrammingTest {

    public static void main(String[] args) {
        Academic ricardoRodriguez = new Academic("Ricardo Rodriguez");
        Academic ismaelBento = new Academic("Ismael Bento");
        Student underGrad1 = new Undergraduate("gg4", "G", "gg4", ricardoRodriguez);
        Student underGrad2 = new Undergraduate("pr3", "P", "pr3", ismaelBento);
        Student postGrad1 = new Postgraduate("te2", "T", "te2", ricardoRodriguez);
        Student postGrad2 = new Postgraduate("yj34", "Y", "yj34", ismaelBento);
        Student postGrad3 = new Postgraduate("jj8", "J", "jj8", ismaelBento);

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(underGrad1);
        studentSet.add(underGrad2);
        studentSet.add(postGrad1);
        studentSet.add(postGrad2);
        studentSet.add(postGrad3);

        Course myCourse = new Course("myCourse", studentSet);
        Set<Postgraduate> ismaelsPostGrads = myCourse.getPostgraduates("Ismael Bento");
        Notifier notifier = new Notifier(ismaelsPostGrads);
        notifier.doNotifyAll("You have been notified");

    }

}
