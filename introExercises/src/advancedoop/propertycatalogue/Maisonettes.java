package advancedoop.propertycatalogue;

public class Maisonettes extends Flats {
    public Maisonettes(int numBathroom, int numBedrooms, int numReceptions, double squareArea) {
        super(numBathroom, numBedrooms, numReceptions, squareArea);
    }

    @Override
    public boolean isMaisonette() {
        return true;
    }

}
