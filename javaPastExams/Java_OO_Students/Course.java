import java.util.HashSet;
import java.util.Set;

public class Course {

    private String name;
    private Set<Student> students;

    public Course(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }

    public Set<Postgraduate> getPostgraduates(String NameOfSupervisor) {
        Set<Postgraduate> allPostGrads = new HashSet<>();
        Academic supervisor = new Academic(NameOfSupervisor);
        for (Student s: students) {
            if(s instanceof Postgraduate) {
               if (((Postgraduate) s).supervisor.name.equals(supervisor.name)) {
                   allPostGrads.add((Postgraduate) s);
               }
            }
        }

        return allPostGrads;
    }
}
