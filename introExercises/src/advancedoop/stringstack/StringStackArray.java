package advancedoop.stringstack;

import java.util.Arrays;

public class StringStackArray implements StringStack {
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

}
