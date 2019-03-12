package advancedoop.intset;

import java.util.HashSet;
import java.util.Set;

public class SpeedEfficientIntSet implements IntSet {
    private Set<Integer> speedSet;

    public SpeedEfficientIntSet() {
        this.speedSet = new HashSet<>();
    }


    @Override
    public void add(int x) {
        speedSet.add(x);
    }

    @Override
    public boolean remove(int x) {
        return speedSet.remove(x);
    }

    @Override
    public boolean isEmpty() {
        return speedSet.isEmpty();
    }

    @Override
    public boolean contains(int x) {
        return speedSet.contains(x);
    }
}
