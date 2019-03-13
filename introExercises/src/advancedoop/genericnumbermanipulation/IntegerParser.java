package advancedoop.genericnumbermanipulation;

public class IntegerParser implements NumberParser<Integer> {
    @Override
    public Integer parseNumber(String s) {
        return Integer.parseInt(s);
    }

    @Override
    public String typeParsed() {
        return "int";
    }

}
