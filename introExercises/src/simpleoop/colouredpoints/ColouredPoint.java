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

    public Colour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return super.toString() + " Colour: " + colour.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ColouredPoint) {
            ColouredPoint a = (ColouredPoint) obj;
            return super.equals(obj) && colour.ordinal() == a.colour.ordinal();
        } else {
            return false;
        }

    }
}
