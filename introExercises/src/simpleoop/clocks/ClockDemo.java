package simpleoop.clocks;

public class ClockDemo {
    public static void main(String[] args) throws InterruptedException {
        Clock c1 = new Clock(0);
        Clock c2 = new Clock(23, 59, 53);
        for (int i = 0; i < 10; i++) {
            System.out.print("Clock 1 shows: " + c1.toString() + ". ");
            System.out.print("Clock 2 shows: " + c2.toString());
            c1.tick();
            c2.tick();
            System.out.println();
            Thread.sleep(1000);
        }

    }
}
