package simpleoop.lecturesoop.generics;

public class GenericPair<S, T> {

    private S first;
    private T second;

    public GenericPair(S first, T second) {
        this.first = first;
        this.second = second;
    }

    public S getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(S first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}

