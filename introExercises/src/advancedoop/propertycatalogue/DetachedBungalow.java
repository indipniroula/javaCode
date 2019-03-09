package advancedoop.propertycatalogue;

public class DetachedBungalow extends DetachedHouse implements Bungalow {
    public DetachedBungalow(int numBathroom, int numBedrooms, int numReceptions, double squareArea) {
        super(numBathroom, numBedrooms, numReceptions, squareArea);
    }

    @Override
    public boolean isBungalow() {
        return true;
    }
}
