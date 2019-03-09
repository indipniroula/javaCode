package advancedoop.propertycatalogue;

public class TerracedHouse extends House {

    public TerracedHouse(int numBathroom, int numBedrooms, int numReceptions, double squareArea) {
        super(numBathroom, numBedrooms, numReceptions, squareArea);
    }

    @Override
    public boolean isTerraced() {
        return true;
    }
}
