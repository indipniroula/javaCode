package simpleoop.simpleinterfaces.arithmeticexperessions;

public class AddExpr extends MultAddGeneralExpr implements Expr {

    public AddExpr(Expr lhs, Expr rhs) {
        super(lhs, rhs);
    }

    @Override
    public int eval() {
        return lhs.eval() + rhs.eval();
    }

}
