package lecturesdatatypes.parallelsets.FineGrainedSet;

import lecturesdatatypes.parallelsets.Node;

import java.util.concurrent.locks.ReentrantLock;

public class LockableNode<E> implements Node<E> {

    private ReentrantLock lock;
    private int key;
    private E item;
    private LockableNode<E> next;


    public LockableNode(E item) {
        this(item, null);
    }

    public LockableNode(E item, LockableNode<E> next) {
        this(item, item.hashCode(), next);
    }

    protected LockableNode(E item, int key, LockableNode<E> next) {
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
    public LockableNode<E> next() {
        return next;
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
        this.next = (LockableNode<E>) next;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }
}
