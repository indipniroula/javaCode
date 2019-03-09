package advancedoop.propertycatalogue;

public class TerracedBungalow extends TerracedHouse implements Bungalow {

    public TerracedBungalow(int numBathroom, int numBedrooms, int numReceptions, double squareArea) {
        super(numBathroom, numBedrooms, numReceptions, squareArea);
    }

    @Override
    public boolean isBungalow() {
        return true;
    }

}
