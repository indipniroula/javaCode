package lectures.intro;

public class Counter {
    private int counter = 0;


    public void run() {
        int cnt = counter;
        counter = cnt + 1;
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
