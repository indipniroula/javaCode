package advancedoop.propertycatalogue;

public abstract class House extends Property {

    public House(int numBathroom, int numBedrooms, int numReceptions, double squareArea) {
        super(numBathroom, numBedrooms, numReceptions, squareArea);
    }

    @Override
    public boolean isHouse() {
        return true;
    }

    @Override
    public boolean isFlat() {
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

}
