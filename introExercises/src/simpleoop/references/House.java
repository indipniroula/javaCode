package simpleoop.references;

public class House {

    public static void main(String[] args) {
        House house = new House(new Rectangle(10, 20));
        house.setFloorSize(new Rectangle(10, 30));
        house.setFloorSize(new Rectangle(10, 40));
        System.out.println(house.getFloorArea());
    }
    private Rectangle floorSize;
    private int floorArea;

    public House(Rectangle floorSize) {
        setFloorSize(floorSize);
    }

    public Rectangle getFloorSize() {
        return new Rectangle(floorSize.getWidth(), floorSize.getHeight());
    }

    public void setFloorSize(Rectangle floorSize) {
        //why can't we do - this.floorSize = floorSize;
        this.floorSize = new Rectangle(floorSize.getWidth(), floorSize.getHeight());
        floorArea = floorSize.getWidth() * floorSize.getHeight();
    }

    public int getFloorArea() {
        return floorArea;
    }

}
