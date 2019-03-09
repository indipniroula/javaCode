package advancedoop.shapes;

public class Rectangle extends Square {
    private int width;

    public Rectangle(int length, int width) {
        super(length);
        this.width = width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    @Override
    public int getSize() {
        if (width == length) {
            return super.getSize();
        } else {
            return width + length;
        }
    }
}
