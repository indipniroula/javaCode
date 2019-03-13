package lecturesdatatypes.parallelsets.FineGrainedSet;

import lecturesdatatypes.parallelsets.C120Set;

import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("unchecked")
public class FineSet<E> implements C120Set<E> {

    AtomicInteger size = new AtomicInteger(0);
    /* Atomic Integer, so can change size with add and remove, without
     using locks. */
    private LockableNode<E> head, tail;

    public FineSet() {
        head = new LockableNode(null, Integer.MIN_VALUE, null);
        tail = new LockableNode(null, Integer.MAX_VALUE, null);
        head.setNext(tail);
    }

    private Position<E> find(LockableNode<E> start, int key) {
        LockableNode<E> pred, curr;
        pred = start;
        pred.lock();
        curr = start.next();
        curr.lock();
        while (curr.key() < key) {
            pred.unlock();
            pred = curr;
            curr = curr.next();
            curr.lock();
        }
        return new Position<E>(pred, curr);
    }

    @Override
    public boolean add(E item) {
        LockableNode<E> node = new LockableNode<>(item);
        LockableNode<E> pred = null, curr = null;
        try {
            Position<E> where = find(head, node.key());
            pred = where.pred;
            curr = where.curr;
            if (where.curr.key() == node.key()) {
                return false;
            } else {
                node.setNext(where.curr);
                where.pred.setNext(node);
                size.incrementAndGet();
                return true;
            }
        } finally {
            pred.unlock();
            curr.unlock();
        }
    }

    @Override
    public boolean remove(E item) {
        LockableNode<E> node = new LockableNode<>(item);
        LockableNode<E> pred = null, curr = null;
        try {
            Position<E> where = find(head, node.key());
            pred = where.pred;
            curr = where.curr;
            if (where.curr.key() > node.key()) {
                return false;
            } else {
                where.pred.setNext(where.curr.next());
                size.decrementAndGet();
                return true;
            }
        } finally {
            pred.unlock();
            curr.unlock();
        }
    }

    @Override
    public boolean contains(E item) {
        LockableNode<E> node = new LockableNode<>(item);
        LockableNode<E> pred = null, curr = null;
        try {
            Position<E> expectedPosition = find(head, node.key());
            pred = expectedPosition.pred;
            curr = expectedPosition.curr;
            return expectedPosition.curr.key() == node.key();
        } finally {
            pred.unlock();
            curr.unlock();
        }
    }

    @Override
    public int size() {
        return size.get();
    }

    private static class Position<T> {

        public final LockableNode<T> pred, curr;

        public Position(LockableNode<T> pred, LockableNode<T> curr) {
            this.pred = pred;
            this.curr = curr;
        }
    }
}

