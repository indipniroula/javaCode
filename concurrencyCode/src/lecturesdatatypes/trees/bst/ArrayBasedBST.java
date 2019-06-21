package lecturesdatatypes.trees.bst;

import java.util.Arrays;

public class ArrayBasedBST<E extends Comparable<E>> implements BST<E> {

    private static final int DEFAULT_CAPACITY = 1024;
    private int size;
    private E[] elements;

    public ArrayBasedBST() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBasedBST(int capacity) {
        size = 0;
        elements = (E[]) new Comparable[capacity];
    }

    public static void main(String[] args) {
        ArrayBasedBST<Integer> bst = new ArrayBasedBST<>((int) Math.pow(2, 4) - 1);
        bst.add(14);
        bst.add(11);
        bst.add(17);
        bst.add(9);
        bst.add(13);
        bst.add(12);
        bst.add(18);

        System.out.println(bst);
    }

    @Override
    public boolean add(E element) {
        return add(0, element);
    }

    private boolean add(int position, E element) {
        if (position >= elements.length) {
            throw new ArrayIndexOutOfBoundsException(
                    "Position " + position + " is beyond the size of the elements");
        }
        if (elements[position] == null) {
            elements[position] = element;
            size = size + 1;
            return true;
        } else {
            if (element.compareTo(elements[position]) == 0) {
                return false; //the element is already in the set
            } else if (element.compareTo(elements[position]) < 0) {
                int positionOfLeftChild = getLeftChildIndex(position);
                return add(positionOfLeftChild, element);
            } else {
                int positionOfRightChild = getRightChildIndex(position);
                return add(positionOfRightChild, element);
            }
        }
    }

    @Override
    public boolean contains(E element) {
        return contains(0, element);
    }

    private boolean contains(int position, E element) {
        if (position >= elements.length) {
            return false;
        }
        if (elements[position] == null) {
            return false;
        } else {
            if (element.compareTo(elements[position]) == 0) {
                return true;
            } else if (element.compareTo(elements[position]) < 0) {
                int positionOfLeftChild = getLeftChildIndex(position);
                return contains(positionOfLeftChild, element);
            } else {
                int positionOfRightChild = getRightChildIndex(position);
                return contains(positionOfRightChild, element);
            }
        }
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    public int size() {
        return size;
    }

    private int getLeftChildIndex(int root) {
        return root * 2 + 1;
    }

    private int getRightChildIndex(int root) {
        return 2 * root + 2;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}

