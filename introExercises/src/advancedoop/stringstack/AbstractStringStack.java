package advancedoop.stringstack;

public abstract class AbstractStringStack implements StringStack {

    @Override
    public String toString() {
        StringStackIterator it = iterator();
        StringBuilder result = new StringBuilder();
        while(it.hasNext()) {
            result.append(it.next() + ", ");
        }
        return result.toString();
    }
}
