package simpleoop.simpleinterfaces.arithmeticexperessions;

/* Created this abstract class, because:
- Addition and Multiplication have exactly same
functionality for everything apart from eval.
So leave eval() incomplete as abstract method.
Override when extending. Leave the rest.
 */

public abstract class MultAddGeneralExpr implements Expr{
    protected final Expr lhs;
    protected final Expr rhs;

    public MultAddGeneralExpr(Expr lhs, Expr rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public abstract int eval();

    @Override
    public int literalCount() {
        return lhs.literalCount() + rhs.literalCount();
    }

    @Override
    public int depth() {
        return 1 + Math.max(lhs.depth(), rhs.depth());
    }
}
