package advancedoop.genericstack;

import java.util.List;

public class Demo {
    public static <E> void transfersStacks(GenericStack<E> dst, GenericStack<E> src) {
        while (!src.isEmpty()) {
            dst.push(src.pop());
        }
    }

    public static void main(String[] args) {
        GenericStackArray<Integer> s1 = new GenericStackArray<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);

        GenericStackList<Integer> s2 = new GenericStackList<>();
        s2.push(6);
        s2.push(5);
        s2.push(4);
        transfersStacks(s2, s1);

        System.out.println(s1);
        System.out.println(s2);


    }
}
