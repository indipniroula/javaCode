package simpleoop.colouredpoints;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(5, 0, 0);
        ColouredPoint n = new ColouredPoint(5, 5, 5, ColouredPoint.Colour.RED);
        System.out.println(n.toString());
        System.out.println(a);
        System.out.println(a.getMagnitude());
    }
}
