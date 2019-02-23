package simpleoop.clocks;

import java.util.ArrayList;
import java.util.List;

public class Clock {
    protected int hours;
    protected int minutes;
    protected int seconds;


    public enum Mode {
        SECOND_FORMAT,
        TwentyFour_FORMAT
    }
    protected Mode mode;

    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        mode = Mode.TwentyFour_FORMAT;
    }

    public Clock(int secondSinceMidnight) {
        this.seconds = secondSinceMidnight;
        mode = Mode.SECOND_FORMAT;
    }

    public void tick() {
       if (mode == Mode.TwentyFour_FORMAT) {
           seconds++;
           if (seconds == 60) {
               seconds = 0;
               minutes++;
               if (minutes == 60) {
                   minutes = 0;
                   hours++;
                   if (hours == 24) {
                       hours = 0;
                   }
               }
           }
       } else {
           seconds++;
       }

    }

    @Override
    public String toString() {
        if (mode == Mode.TwentyFour_FORMAT) {
            int[] time = {hours, minutes, seconds};
            List<String> stringTime = new ArrayList<>();
            for (int unit: time) {
                if (unit <= 9) {
                    stringTime.add("0" + unit);
                } else {
                    stringTime.add(String.valueOf(unit));
                }
            }
            return stringTime.get(0) + ":" + stringTime.get(1) + ":" + stringTime.get(2);
        } else {
            return seconds + " second since midnight";
        }
    }
}
