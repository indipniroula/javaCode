package datastructures.queues;

import java.util.ArrayList;
import java.util.List;

//Implementing Generic Queue using Lists.
public class GenericQueue<T> {

    List<T> _queue = new ArrayList<>();

    private boolean hasElements() {
        return !_queue.isEmpty();
    }

    public T peek() {
        T result = null;
        if (this.hasElements()) {
            result = _queue.get(0);
        }

        return result;
    }

    public void add(T element) {
        _queue.add(element);
    }

    public T poll() {
        T result = null;
        if (this.hasElements()) {
            result = _queue.remove(0);
        }
        return result;
    }

    public static void main(String[] args) {
        GenericQueue<Integer> queue = new GenericQueue<>();
        assert queue.peek() == null;
        queue.add(1);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
