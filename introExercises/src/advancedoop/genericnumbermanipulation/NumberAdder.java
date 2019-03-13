package advancedoop.genericnumbermanipulation;

public interface NumberAdder<T extends Number> {

    T zero();

    T add(T x, T y);
}
