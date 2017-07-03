package ferry.booking.services;

import ferry.booking.AvailableCrossing;
import ferry.booking.model.ferry.Port;
import ferry.booking.model.ferry.Ferry;
import ferry.booking.model.journey.Booking;;
import ferry.booking.model.timetable.TimeTableEntry;
import ferry.booking.model.timetable.TimeTableViewModelRow;

import java.util.ArrayList;
import java.util.List;

public class TimeTableService {

    private final List<Booking> bookings;
    private final FerryAvailabilityService ferryService;
    private final List<TimeTableEntry> allEntries;
    private final List<Port> ports;

    public TimeTableService(List<TimeTableEntry> allEntries, List<Port> ports, List<Booking> bookings, FerryAvailabilityService ferryService) {
        this.allEntries = allEntries;
        this.bookings = bookings;
        this.ferryService = ferryService;
        this.ports = ports;
    }

    public List<TimeTableViewModelRow> getTimeTable(List<Port> ports) {
        List<TimeTableViewModelRow> rows = new ArrayList<TimeTableViewModelRow>();
        for (TimeTableEntry timetable : allEntries) {

            Port origin = searchPortById(ports,  timetable.originId);
            Port destination = searchPortById(ports,  timetable.destinationId);
            assert(origin!=null);
            assert(destination!=null);
            String destinationName = destination.name;
            String originName = origin.name;
            Ferry ferry = ferryService.nextFerryAvailableFrom(origin.id, timetable.time);
            //TODO check null
            long arrivalTime = timetable.time + timetable.journeyTime;
            //TODO  move this output
            //possible bug here
            TimeTableViewModelRow row = setUpTimetableRow(timetable, destinationName, originName, ferry == null ? "" : ferry.name, arrivalTime);
            rows.add(row);
        }
        return rows;
    }

    private TimeTableViewModelRow setUpTimetableRow(TimeTableEntry timetable, String destinationName, String originName, String ferryName, long arrivalTime) {
        TimeTableViewModelRow row = new TimeTableViewModelRow();
        //TODO MOVE TO A FACTORY
        row.destinationPort = destinationName;
        row.ferryName = ferryName;
        row.journeyLength = String.format("%02d:%02d", timetable.journeyTime / 60, timetable.journeyTime % 60);
        row.originPort = originName;
        row.startTime = String.format("%02d:%02d", timetable.time / 60, timetable.time % 60);
        row.arrivalTime = String.format("%02d:%02d", arrivalTime / 60, arrivalTime % 60);
        return row;
    }

    private Port searchPortById(List<Port> ports, int idToSearch) {
        Port origin = null;
        for (Port x : ports) {
            if (x.id ==idToSearch) {
                origin = x;
            }
        }
        return origin;
    }


    public List<AvailableCrossing> getAvailableCrossings(long time, int fromPort, int toPort) {
        List<AvailableCrossing> result = new ArrayList<AvailableCrossing>();

        for (TimeTableEntry timetable : allEntries) {
            Port origin = searchPortById(ports,  timetable.originId);
            Port destination = searchPortById(ports,  timetable.destinationId);

            if (!areAvailablePortsOriginDestination(fromPort, toPort, origin, destination)) {
                continue;
            }
            if (!isInsidedAvailableTime(time, timetable)) {
                continue;
            }
            List<Booking> journeyBookings = getBookingsByTimetableId(timetable.id);
            int pax = countPassangers(journeyBookings);
            Ferry ferry = ferryService.nextFerryAvailableFrom(timetable.originId, timetable.time);

            int seatsLeft = ferry.passengers - pax;
            if (!areSeatsLeft(seatsLeft)) {
                continue;
            }
            //TODO  create available crossing
            AvailableCrossing crossing = setUpAvailableCrossing(timetable, origin, destination, journeyBookings, ferry);
            result.add(crossing);
        }
        return result;
    }



    private AvailableCrossing setUpAvailableCrossing(TimeTableEntry timetable, Port origin, Port destination, List<Booking> journeyBookings, Ferry ferry) {
        AvailableCrossing crossing = new AvailableCrossing();
        crossing.arrive = timetable.time + timetable.journeyTime;
        crossing.ferryName = ferry.name;
        int pax2 = countPassangers(journeyBookings);
        crossing.seatsLeft = ferry.passengers - pax2;
        crossing.setOff = timetable.time;
        crossing.originPort = origin.name;
        crossing.destinationPort = destination.name;
        crossing.journeyId = timetable.id;
        return crossing;
    }

    private List<Booking> getBookingsByTimetableId(int id) {
        List<Booking> journeyBookings = new ArrayList<>();
        for (Booking x : bookings) {
            if (x.journeyId == id) {
                journeyBookings.add(x);
            }
        }
        return journeyBookings;
    }

    private int countPassangers(List<Booking> journeyBookings) {
        int pax = 0;
        for (Booking x : journeyBookings) {
            pax += x.passengers;
        }
        return pax;
    }

    private boolean isInsidedAvailableTime(long time, TimeTableEntry timetable) {
        return timetable.time >= time;
    }

    private boolean areAvailablePortsOriginDestination(int fromPort, int toPort, Port origin, Port destination) {
        return toPort == destination.id && fromPort == origin.id;
    }

    private boolean areSeatsLeft(int seatsLeft) {
        return seatsLeft > 0;
    }
}
