package advancedoop.intset;

import java.util.HashSet;
import java.util.Set;

public class MemoryEfficientIntSet implements IntSet {
    private Set<Integer> memorySet;

    public MemoryEfficientIntSet() {
        this.memorySet = new HashSet<>();
    }


    @Override
    public void add(int x) {
        memorySet.add(x);
    }

    @Override
    public boolean remove(int x) {
        return memorySet.remove(x);
        // Above wrong:
    }

    @Override
    public boolean isEmpty() {
        return memorySet.isEmpty();
    }

    @Override
    public boolean contains(int x) {
        return memorySet.contains(x);
    }
}
