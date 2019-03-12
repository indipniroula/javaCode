package advancedoop.stringstack;

public class Demo {

    public static void main(String[] args) {
        StringStack a1 = new StringStackArray();
        a1.push("Hi");
        a1.push("hello");
        a1.push("What");
        StringStack a2 = new StringStackList();
        transfersStacks(a2, a1);
        assert  a1.isEmpty();
        while (!a2.isEmpty()) {
            System.out.println(a2.pop());
        }

    }

    public static void transfersStacks(StringStack dst, StringStack src) {
        while (!src.isEmpty()) {
            dst.push(src.pop());
        }
    }
}
