package lecturesdatatypes.parallelsets.Sequential;

import lecturesdatatypes.parallelsets.Node;

public class SequentialNode<E> implements Node<E> {
    private E item;
    private Node<E> next;
    private int key;

    public SequentialNode(E item) {
        this(item, null);
    }

    public SequentialNode(E item, Node<E> next) {
        this(item, item.hashCode(), next);
    }

    protected SequentialNode(E item, int key, Node<E> next) {
        this.item = item;
        this.key = key;
        this.next = next;
    }


    @Override
    public E item() {
        return item;
    }

    @Override
    public int key() {
        return key;
    }

    @Override
    public Node<E> next() {
        return this.next;
    }

    @Override
    public void setItem(E item) {
        this.item = item;
    }

    @Override
    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public void setNext(Node<E> next) {
        this.next = next;
    }
}
