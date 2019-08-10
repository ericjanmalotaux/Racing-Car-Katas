package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestAlarm {

    private final Sensor sensor = mock(Sensor.class);

    @Test
    public void withinBound() {
        doTest(20.0, false);
    }

    private void doTest(double value, boolean result) {
        when(sensor.popNextPressurePsiValue()).thenReturn(value);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertThat(alarm.isAlarmOn(), is(result));
    }

    @Test
    public void onUpperBound() {
        doTest(21.0, false);
    }

    @Test
    public void onLowerBound() {
        doTest(17.0, false);
    }

    @Test
    public void overUpperBound() {
        doTest(21.1, true);
    }

    @Test
    public void underLowerBound() {
        doTest(16.9, true);
    }
}
