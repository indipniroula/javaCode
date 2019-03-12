package advancedoop.stringstack;

import java.util.Arrays;
import java.util.Iterator;

public class StringStackArray extends AbstractStringStack{
    private final int MAX_ELEMENTS = 100;
    private String[] stackString;
    private int stackHeight = 0;

    public StringStackArray() {
        this.stackString = new String[MAX_ELEMENTS];
    }

    @Override
    public void push(String s) {
        if (!(stackHeight >= 100)) {
            stackString[MAX_ELEMENTS - stackHeight - 1] = s;
            stackHeight++;
        }
    }

    @Override
    public String pop() {
        if (!(stackHeight == 0)) {
            String result = stackString[MAX_ELEMENTS - stackHeight];
            stackString[MAX_ELEMENTS - stackHeight] = null;
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
    public StringStackIterator iterator() {
        return new StringStackArrayIterator();
    }


    private class StringStackArrayIterator implements StringStackIterator {

        private int iteratorPointer = MAX_ELEMENTS - stackHeight;

        @Override
        public boolean hasNext() {
            return iteratorPointer < MAX_ELEMENTS;
        }

        @Override
        public String next() {
            String result;
            if (hasNext()) {
                result = stackString[iteratorPointer];
                iteratorPointer++;
                return result;
            }
            return null;

        }
    }
}
