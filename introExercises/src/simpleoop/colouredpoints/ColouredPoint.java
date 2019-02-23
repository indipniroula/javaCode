package simpleoop.colouredpoints;

public class ColouredPoint extends Point {
    enum Colour {
        RED,
        GREEN,
        BLUE
    }

    private final Colour colour;

    public ColouredPoint(double x, double y, double z, Colour colour) {
        super(x, y, z);
        this.colour = colour;
    }

    @Override
    public String toString() {
        return super.toString() + " Colour: " + colour.toString();
    }
}
