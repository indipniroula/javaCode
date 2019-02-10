package simpleoop.simpleinterfaces.arithmeticexperessions;

public class LiteralExpr implements Expr{
    private final int value;

    public LiteralExpr(int value) {
        this.value = value;
    }

    public int eval() {
        return value;
    }

    public int literalCount() {
        return 1;
    }

    @Override
    public int depth() {
        return 0;
    }
}
