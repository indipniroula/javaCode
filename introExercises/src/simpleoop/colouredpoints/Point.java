package simpleoop.colouredpoints;

public class Point {
    private final double x;
    private final double y;
    private final double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getDistanceTo(Point other){
        double deltaXSquared = Math.pow(x-other.x, 2);
        double deltaYSquared = Math.pow(y-other.y, 2);
        double deltaZSquared = Math.pow(z-other.z, 2);
        return Math.sqrt(deltaXSquared + deltaYSquared + deltaZSquared);
    }

    public Point getOrigin() {
        return new Point(0.0, 0.0, 0.0);
    }

    public double getMagnitude() {
        return getDistanceTo(getOrigin());
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
