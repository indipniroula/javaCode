package simpleoop.simpleinterfaces.arithmeticexperessions;

public class MultExpr extends MultAddGeneralExpr implements Expr {

    public MultExpr(Expr lhs, Expr rhs) {
        super(lhs, rhs);
    }

    @Override
    public int eval() {
        return lhs.eval() * rhs.eval();
    }
}

