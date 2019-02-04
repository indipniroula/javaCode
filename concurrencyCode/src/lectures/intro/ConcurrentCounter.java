package lectures.intro;

public class ConcurrentCounter extends Counter implements Runnable {
    public static void main(String[] args) {
        ConcurrentCounter counter = new ConcurrentCounter();

        Thread t = new Thread(counter);
        Thread u = new Thread(counter);


        // Race conditions: Need to synchronize
        // Can also use locks
        t.start();
        u.start();
        try {
//            t.sleep(10000); sleep thread for number of milliseconds
//            u.sleep(10000);
            t.join();
            u.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getCounter());
    }

}
