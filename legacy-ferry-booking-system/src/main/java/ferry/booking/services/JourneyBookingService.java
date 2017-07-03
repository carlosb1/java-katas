package ferry.booking.services;

import ferry.booking.model.ferry.Ferry;
import ferry.booking.model.journey.Booking;;
import ferry.booking.model.timetable.TimeTableEntry;

import java.util.ArrayList;
import java.util.List;

public class JourneyBookingService {

    private List<TimeTableEntry> allEntries;
    private List<Booking> bookings;
    private final FerryAvailabilityService ferryService;

    public JourneyBookingService( List<TimeTableEntry> allEntries, List<Booking> bookings, FerryAvailabilityService ferryService) {
        this.allEntries = allEntries;
        this.bookings = bookings;
        this.ferryService = ferryService;
    }

    private int countPassangers(List<Booking> journeyBookings) {
        int pax = 0;
        for (Booking x : journeyBookings) {
            pax += x.passengers;
        }
        return pax;
    }


    public boolean canBook(int journeyId, int passengers) {
        for (TimeTableEntry timetable : allEntries) {
            if (timetable.id == journeyId) {
                int pax = countPassangers(bookings);
                Ferry ferry = ferryService.nextFerryAvailableFrom(timetable.originId, timetable.time);
                int seatsLeft = ferry.passengers - pax;
                return seatsLeft >= passengers;
            }
        }
        return false;
    }

    public void book(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}
