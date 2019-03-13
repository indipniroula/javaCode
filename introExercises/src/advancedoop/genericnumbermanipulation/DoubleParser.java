package advancedoop.genericnumbermanipulation;

public class DoubleParser implements NumberParser<Double> {

    @Override
    public Double parseNumber(String s) {
        return Double.parseDouble(s);
    }

    @Override
    public String typeParsed() {
        return "double";
    }
}
