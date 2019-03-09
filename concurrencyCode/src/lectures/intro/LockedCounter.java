package lectures.intro;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedCounter extends ConcurrentCounter {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockedCounter counter = new LockedCounter();
        Thread t = new Thread(counter);
        Thread u = new Thread(counter);
        Thread v = new Thread(counter);

        t.start();
        u.start();
        v.start();

        try {
            t.join();
            u.join();
            v.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCounter());
    }

    @Override
    public void run() {
        lock.lock();
        try {
            super.run(); //execute run implementation of parent
        } finally {
            lock.unlock();
        }
        /* Always want to unlock() at the end, even in case of
        exceptions, hence you run all critical sections in a try
        block, with a finally block that will always do lock.unlock()
         */
    }

    // Locks not required.
    // Every lock has implicit Lock - use synchronized keyword.





}
