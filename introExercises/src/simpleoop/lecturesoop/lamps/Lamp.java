package simpleoop.lecturesoop.lamps;

public class Lamp {

    protected boolean isOn;

    public Lamp() {}

    public Lamp(boolean isOn) {
        this.isOn = isOn;
    }

    public void pressSwitch() {
        isOn = !isOn;
    }

    @Override
    public String toString() {
        return "Lamp(" +
                (isOn ? "on" : "off" ) + ")";
    }
}
