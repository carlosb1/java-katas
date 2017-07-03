package ferry.booking.model.ferry;

import ferry.booking.model.timetable.TimeTableEntry;

public class FerryModule {

    public static long timeReady(TimeTableEntry timetable, PortModel destination) {
        if (timetable == null) {
            return 0;
        }
        if (destination == null) {
            throw new NullPointerException("destination");
        }

        long arrivalTime = timetable.time + timetable.journeyTime;
        int turnaroundTime = FerryManager.getFerryTurnaroundTime(destination);
        long timeReady = arrivalTime + turnaroundTime;
        return timeReady;
    }
}
