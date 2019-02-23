package simpleoop.clocks;

public class AlarmClockDemo {
    public static void main(String[] args) throws InterruptedException {
        AlarmClock c2 = new AlarmClock(22, 59, 56, new Clock(22, 59, 58));
        for (int i = 0; i < 70; i++) {
            System.out.println("Clock shows: " + c2.toString());
            c2.tick();
            Thread.sleep(10);
        }

    }
}
