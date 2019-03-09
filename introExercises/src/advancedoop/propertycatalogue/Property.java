package advancedoop.propertycatalogue;

public abstract class Property {

    protected final int numBathroom;
    protected final int numBedrooms;
    protected final int numReceptions;
    protected final double squareArea;

    public Property(int numBathroom, int numBedrooms, int numReceptions, double squareArea) {
        this.numBathroom = numBathroom;
        this.numBedrooms = numBedrooms;
        this.numReceptions = numReceptions;
        this.squareArea = squareArea;
    }

    public abstract boolean isHouse();
    public abstract boolean isBungalow();
    public abstract boolean isFlat();
    public abstract boolean isMaisonette();
    public abstract boolean isTerraced();
}
