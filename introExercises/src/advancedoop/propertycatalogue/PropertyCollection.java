package advancedoop.propertycatalogue;

import java.util.HashSet;
import java.util.Set;

public class PropertyCollection {

    Set<Property> properties = new HashSet<>();

    public PropertyCollection() {
    }

    public void addProperty(Property p) {
        properties.add(p);
    }

    public Set<House> getHouses() {
        Set<House> result = new HashSet<>();
        for (Property p : properties) {
            if (p.isHouse()) {
                result.add((House) p);
            }
        }
        return result;
    }

    public Set<Bungalow> getBungalows() {
        Set<Bungalow> result = new HashSet<>();
        for (Property p : properties) {
            if (p.isBungalow()) {
                result.add((Bungalow) p);
            }
        }
        return result;
    }

    public Set<Flats> getFlats() {
        Set<Flats> result = new HashSet<>();
        for (Property p : properties) {
            if (p.isFlat()) {
                result.add((Flats) p);
            }
        }
        return result;
    }

    public Set<Maisonettes> getMaisonettes() {
        Set<Maisonettes> result = new HashSet<>();
        for (Property p : properties) {
            if (p.isMaisonette()) {
                result.add((Maisonettes) p);
            }
        }
        return result;
    }

    public Set<TerracedHouse> getTerracedHouse() {
        Set<TerracedHouse> result = new HashSet<>();
        for (Property p : properties) {
            if (p.isTerraced()) {
                result.add((TerracedHouse) p);
            }
        }
        return result;
    }


}
