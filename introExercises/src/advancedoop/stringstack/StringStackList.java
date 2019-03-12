package advancedoop.stringstack;

import java.util.*;
import java.util.stream.Collectors;

public class StringStackList implements StringStack {
    List<String> stackString;

    public StringStackList() {
        stackString = new LinkedList<>();
    }

    @Override
    public void push(String s) {
        stackString.add(0, s);
    }

    @Override
    public String pop() {
        if (stackString.size() > 0) {
            return stackString.remove(0);
        }
        return null;

    }

    @Override
    public boolean isEmpty() {
        return stackString.isEmpty();
    }

}
