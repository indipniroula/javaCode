package lectures.intro;

public class SynchronizedMethodCounter implements Runnable {
    private int counter;

    public static void main(String[] args) {
        SynchronizedMethodCounter counter = new SynchronizedMethodCounter();
        Thread t = new Thread(counter);
        Thread u = new Thread(counter);

        t.start();
        u.start();
        // Threads now ready to be executed at this stage.

        try {
            t.join();
            u.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getCounter());
    }
    @Override
    public synchronized void run() {
        int cnt;
        for (int i = 0; i < 10000000; i++) {
            cnt = counter;
            counter = cnt + 1;
        }
    }

    public int getCounter() {
        return counter;
    }
}
