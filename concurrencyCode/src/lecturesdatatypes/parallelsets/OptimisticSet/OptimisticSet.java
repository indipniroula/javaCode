package lecturesdatatypes.parallelsets.OptimisticSet;

import lecturesdatatypes.parallelsets.C120Set;
import lecturesdatatypes.parallelsets.Node;

import java.util.concurrent.atomic.AtomicInteger;

public class OptimisticSet<E>  implements C120Set<E> {

    protected AtomicInteger size = new AtomicInteger(0);
    protected ReadWriteNode<E> head, tail;

    public OptimisticSet() {
        head = new ReadWriteNode(null, Integer.MIN_VALUE, null);
        tail = new ReadWriteNode(null, Integer.MAX_VALUE, null);
        head.setNext(tail);
    }

    private boolean valid(Node<E> pred, Node<E> curr) {
        Node<E> node = head;
        while (node.key() <= pred.key()) {
            if (node == pred) {
                return pred.next() == curr;
            }
            node = node.next();
        }
        return false;
    }

    protected Position<E> find(ReadWriteNode<E> start, int key) {
        ReadWriteNode<E> pred, curr;
        curr = start;
        do {
            pred = curr;
            curr = curr.next();
        } while (curr.key() < key);

        return new Position<E>(pred, curr);
    }

    @Override
    public boolean add(E item) {
        ReadWriteNode<E> node = new ReadWriteNode<>(item);
        do {
            Position<E> where = find(head, node.key());
            ReadWriteNode<E> pred = where.pred, curr = where.curr;
            pred.lock();
            curr.lock();
            try {
                if (valid(pred, curr)) {
                    if (where.curr.key() == node.key()) {
                        return false;
                    } else {
                        node.setNext(where.curr);
                        where.pred.setNext(node);
                        size.incrementAndGet();
                        return true;
                    }
                }
            } finally {
                pred.unlock();
                curr.unlock();
            }
        } while (true);
    }

    @Override
    public boolean remove(E item) {
        Node<E> node = new ReadWriteNode<>(item);
        do {
            Position<E> where = find(head, node.key());
            ReadWriteNode<E> pred = where.pred, curr = where.curr;
            pred.lock();
            curr.lock();
            try {
                if (valid(pred, curr)) {
                    if (where.curr.key() > node.key()) {
                        return false;
                    } else {
                        where.pred.setNext(where.curr.next());
                        size.decrementAndGet();
                        return true;
                    }
                }
            } finally {
                pred.unlock();
                curr.unlock();
            }
        } while (true);
    }

    @Override
    public boolean contains(E item) {
        Node<E> node = new ReadWriteNode<>(item);
        do {
            Position<E> where = find(head, node.key());
            ReadWriteNode<E> pred = where.pred, curr = where.curr;
            pred.lock();
            curr.lock();
            try {
                if (valid(pred, curr)) {
                    return where.curr.key() == node.key();
                }
            } finally {
                pred.unlock();
                curr.unlock();
            }
        } while (true);
    }

    @Override
    public int size() {
        return size.get();
    }

    protected static class Position<T> {

        public final ReadWriteNode<T> pred, curr;

        public Position(ReadWriteNode<T> pred, ReadWriteNode<T> curr) {
            this.pred = pred;
            this.curr = curr;
        }
    }
}

