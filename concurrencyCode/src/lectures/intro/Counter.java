package lectures.intro;

public class Counter {
    private int counter = 0;


    public void run() {
        int cnt;
        for (int i = 0; i < 10000000; i++) {
            cnt = counter;
            counter = cnt + 1;
        }
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.run();
        counter.run();

        System.out.println(counter.getCounter());
    }
}
