package advancedoop.propertycatalogue;

public class Flats extends Property {

    public Flats(int numBathroom, int numBedrooms, int numReceptions, double squareArea) {
        super(numBathroom, numBedrooms, numReceptions, squareArea);
    }

    @Override
    public boolean isHouse() {
        return false;
    }

    @Override
    public boolean isMaisonette() {
        return false;
    }

    @Override
    public boolean isBungalow() {
        return false;
    }

    @Override
    public boolean isTerraced() {
        return false;
    }

    @Override
    public boolean isFlat() {
        return true;
    }
}
