package simpleoop.clocks;

public class AlarmClock extends Clock {
    private final Clock alarmTime;
    private boolean alarmSounding;
    private final int ALARM_TIME = 60;

    public AlarmClock(int secondSinceMidnight, Clock alarmTime) {
        super(secondSinceMidnight);
        this.alarmTime = alarmTime;
        this.alarmSounding = false;
    }

    public AlarmClock(int hours, int minutes, int seconds, Clock alarmTime) {
        super(hours, minutes, seconds);
        this.alarmTime = alarmTime;
        this.alarmSounding = false;
    }

    @Override
    public void tick() {
        super.tick();
        if (super.mode == Mode.SECOND_FORMAT) {
            if (alarmTime.seconds == this.seconds) {
                alarmSounding = true;
            }
            if (this.seconds - alarmTime.seconds == ALARM_TIME) {
                alarmSounding = false;
            }
        } else {
           int timeInSeconds = hours * 60 * 60 + minutes * 60 + seconds;
           int alarmTimeInSeconds = alarmTime.hours * 60 * 60 + alarmTime.minutes * 60 + alarmTime.seconds;
           if (timeInSeconds == alarmTimeInSeconds) {
               alarmSounding = true;
           }
           if (timeInSeconds - alarmTimeInSeconds == 60){
               alarmSounding = false;
           }
        }
    }

    @Override
    public String toString() {
        if (alarmSounding) {
            return super.toString() + " BEEP!";
        } else {
            return super.toString();
        }
    }
}
