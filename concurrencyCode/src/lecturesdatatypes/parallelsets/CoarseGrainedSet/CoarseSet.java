package lecturesdatatypes.parallelsets.CoarseGrainedSet;

import lecturesdatatypes.parallelsets.Sequential.SequentialSet;

public class CoarseSet<E> extends SequentialSet<E> {
    //Alternative
    //Create Reentrant Lock object
    // and lock all the methods , using try-finally block instead of synchronized.


    @Override
    public synchronized boolean contains(E item) {
        return super.contains(item);
    }

    @Override
    public synchronized boolean remove(E item) {
        return super.remove(item);
    }

    @Override
    public synchronized boolean add(E item) {
        return super.add(item);
    }

    @Override
    public synchronized int size() {
        return super.size();
    }

}
