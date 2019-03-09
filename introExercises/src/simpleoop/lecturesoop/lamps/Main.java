package simpleoop.lecturesoop.lamps;


public class Main {
    public static void main(String[] args) {
        Lamp l = new AdjustableLamp(true);
        System.out.println(l);
        l.pressSwitch();
        System.out.println(l);

    }

}
