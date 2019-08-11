package tddmicroexercises.tirepressuremonitoringsystem

import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.*
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.*

class TestAlarm {

    @Test fun withinBounds() = doTest(20.0, false)
    @Test fun upperBound() = doTest(21.0, false)
    @Test fun lowerBound() = doTest(17.0, false)
    @Test fun overUpperBound() = doTest(21.1, true)
    @Test fun underLowerBound() = doTest(16.9, true)

    val sensor: Sensor = mock(Sensor::class.java)

    private fun doTest(value: Double, result: Boolean) {
        `when`(sensor.popNextPressurePsiValue()).thenReturn(value)
        val alarm = Alarm(sensor)
        alarm.check()
        assertThat(alarm.isAlarmOn, `is`(result))
    }
}
