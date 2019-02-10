package simpleoop.simpleinterfaces.arithmeticexperessions;

public class Demo {

    public static void main(String[] args) {
        Expr a = new AddExpr(new LiteralExpr(2), new LiteralExpr(10));
        Expr b = new MultExpr(a, a);
        System.out.println(b.eval());
        System.out.println(b.literalCount());
        System.out.println(b.depth());
    }

}
