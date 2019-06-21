package lecturesdatatypes.trees.bst;


public interface BST<E extends Comparable<E>> {

    boolean add(E element);

    boolean remove(E element);

    boolean contains(E element);

}

