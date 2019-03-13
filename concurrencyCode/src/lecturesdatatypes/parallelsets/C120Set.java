package lecturesdatatypes.parallelsets;

//We will implement set using a linked list - 'linked set'.
// e.g using pointers and nodes like a linked list.

public interface C120Set<E> {
    boolean add(E item);

    boolean remove(E item);

    boolean contains(E item);

    int size();

}
