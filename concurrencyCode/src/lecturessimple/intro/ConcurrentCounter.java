package lecturessimple.intro;

public class ConcurrentCounter extends Counter implements Runnable {
    // Implements Runnable but don't need to implement the run function
    // run function is implemented in superclass (Counter), which is inherited
    public static void main(String[] args) {

        ConcurrentCounter counter = new ConcurrentCounter();

        Thread t = new Thread(counter);
        Thread u = new Thread(counter);
        Thread z = new Thread(counter);


        // Race conditions: Need to synchronize
        // Can also use locks
        t.start();
        u.start();
        z.start();
        try {
//            t.sleep(10000); sleep thread for number of milliseconds
//            u.sleep(10000);
            t.join();
            u.join();
            z.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /* When .join() method is called, the run() method of
        the thread is executed. Hence, here it is counter = cnt + 1
        method. We wait until both threads execute - could be problems
        so try-catch.
         */

        System.out.println(counter.getCounter());
    }

}
