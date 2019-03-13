package advancedoop.genericnumbermanipulation;

public interface NumberParser<E extends Number> {

    E parseNumber(String s);

    String typeParsed();
}
