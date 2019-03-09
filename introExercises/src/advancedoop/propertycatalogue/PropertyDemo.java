package advancedoop.propertycatalogue;

public class PropertyDemo {
    public static void main(String[] args) {
        PropertyCollection setOfAll = new PropertyCollection();
        for (int i = 0; i < 1000; i++) {
            setOfAll.addProperty(new SemiDetachedHouse(0,0,0,0));
            setOfAll.addProperty(new TerracedHouse(0,0,0,0));
        }

        for (int i = 0; i < 100; i++) {
            setOfAll.addProperty(new DetachedHouse(0,0,0,0));
            setOfAll.addProperty(new SemiDetachedBungalow(0,0,0,0));
            setOfAll.addProperty(new Flats(0,0,0,0));
        }

        for (int i = 0; i < 20; i++) {
            setOfAll.addProperty(new DetachedBungalow(0,0,0,0));
            setOfAll.addProperty(new Maisonettes(0,0,0,0));
            setOfAll.addProperty(new TerracedBungalow(0,0,0,0));
        }

        System.out.println(setOfAll.getHouses().size() + " total houses");

        System.out.println(setOfAll.getBungalows().size() + " total Bungalows");

        System.out.println(setOfAll.getFlats().size() + " total Flats");

        System.out.println(setOfAll.getMaisonettes().size() + " Total Maisonettes");

        System.out.println(setOfAll.getTerracedHouse().size() + " Total Terraced Houses");




    }
}
