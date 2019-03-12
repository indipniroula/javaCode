package advancedoop.genericstack;

import java.util.Arrays;

public class GenericStackArray<E> implements GenericStack<E> {
    private final int MAX_ELEMENTS = 100;
    private E[] genericStack;
    private int stackHeight = 0;

    @SuppressWarnings("unchecked")
    public GenericStackArray() {
        this.genericStack = (E[]) new Object[MAX_ELEMENTS];
    }

    @Override
    public void push(E s) {
        if (!(stackHeight >= 100)) {
            genericStack[MAX_ELEMENTS - stackHeight - 1] = s;
            stackHeight++;
        }
    }

    @Override
    public E pop() {
        if (!(stackHeight == 0)) {
            E result = genericStack[MAX_ELEMENTS - stackHeight];
            genericStack[MAX_ELEMENTS - stackHeight] = null;
            stackHeight--;
            return result;
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return stackHeight == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(genericStack);
    }
}
