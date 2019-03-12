package advancedoop.stringstack;

public class IteratorDemo {

    public static void main(String[] args) {
        StringStackArray stack1 = new StringStackArray();
        StringStackList stack2 = new StringStackList();

        stack1.push("Array1");
        stack1.push("Array 2");
        stack2.push("List 1");
        stack2.push("List 2");
        System.out.println(stack1);
        System.out.println(stack2);
        Demo.transfersStacks(stack2, stack1);
        System.out.println(stack1);
        System.out.println(stack2);

    }



}
