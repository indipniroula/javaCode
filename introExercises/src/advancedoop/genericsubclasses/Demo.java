package advancedoop.genericsubclasses;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Set<B> setOfB = new HashSet<>();
        Set<? extends A> setOfA = setOfB;
        // Can't add anything to setOfA - read-only
        // Can't add - as can't gurantee safety.



    }
}
