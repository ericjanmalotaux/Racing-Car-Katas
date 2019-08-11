package tddmicroexercises.tirepressuremonitoringsystem

class Alarm(private val sensor: Sensor) {
    private val LowPressureThreshold = 17.0
    private val HighPressureThreshold = 21.0

    var isAlarmOn = false
        internal set

    fun check() {
        isAlarmOn = sensor.popNextPressurePsiValue() !in LowPressureThreshold..HighPressureThreshold
    }

}
