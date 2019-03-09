package simpleoop.colouredpoints;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(5, 0, 0);
        Point b = new Point(5, 0 , 0);
        System.out.println(a.equals(b));

        ColouredPoint n = new ColouredPoint(5, 0, 0, ColouredPoint.Colour.RED);
        ColouredPoint c = new ColouredPoint(5, 5, 5, ColouredPoint.Colour.RED);
        System.out.println(n.equals(c));

        System.out.println(a.equals(n));
        System.out.println(n.equals(a));




    }
}
