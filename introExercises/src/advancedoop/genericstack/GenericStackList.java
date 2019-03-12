package advancedoop.genericstack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenericStackList<E> implements GenericStack<E> {
    private List<E> genericStack;

    public GenericStackList() {
        genericStack = new LinkedList<>();
    }

    @Override
    public void push(E s) {
        genericStack.add(0, s);
    }

    @Override
    public E pop() {
        if (genericStack.size() > 0) {
            return genericStack.remove(0);
        }
        return null;

    }

    @Override
    public boolean isEmpty() {
        return genericStack.isEmpty();
    }

    @Override
    public String toString() {
        return genericStack.toString();
    }
}
