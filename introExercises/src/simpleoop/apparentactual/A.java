package simpleoop.apparentactual;

public class A {

}

class B extends A {

}

class C {

    public void accept(A a) {
        System.out.println("Accepted object of type A");
    }
}

class D extends C {


    //D inherits accept(A a) from C.



    // Also has accept(B b). so accept is overloaded.
    public void accept(B b) {
        System.out.println("Accepted object of type B");
    }

}

class Test {
    public static void main(String[] args) {
        A a = new A();

        B b = new B();

        C c = new D();
        c.accept(b); // upcast happens automatically.

        D d = new D();
        // accept is an overloaded method in class D.
        d.accept(a);
        d.accept(b);
    }
}
