package simpleoop.lecturesoop.lamps;

public class AdjustableLamp extends Lamp {

    private int brightness;

    public AdjustableLamp(boolean isOn) {
        super(isOn);
        brightness = (isOn ? 10 : 0);
    }

    @Override
    public void pressSwitch() {
        super.pressSwitch();
        brightness = (isOn ? 10 : 0);
    }

    public void dim() {
        if (isOn && brightness > 1) {
            brightness -= 1;
        }
    }

    @Override
    public String toString() {
        return "Adjustable Lamp(" + (isOn ? "on" : "off")
                + ", " + brightness + ")";
    }
}
