package advancedoop.propertycatalogue;

public class SemiDetachedBungalow extends SemiDetachedHouse implements Bungalow {

    public SemiDetachedBungalow(int numBathroom, int numBedrooms, int numReceptions, double squareArea) {
        super(numBathroom, numBedrooms, numReceptions, squareArea);
    }

    @Override
    public boolean isBungalow() {
        return true;
    }
}
