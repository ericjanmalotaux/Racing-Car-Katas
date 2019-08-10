package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {

    private Sensor sensor;
    private boolean alarmOn = false;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    public void check() {
        alarmOn = !withinBounds(sensor.popNextPressurePsiValue());
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

    private boolean withinBounds(double psiPressureValue) {
        return (double) 17 <= psiPressureValue && psiPressureValue <= (double) 21;
    }
}
