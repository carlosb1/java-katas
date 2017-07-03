package ferry.booking;

import ferry.booking.model.ferry.*;
import ferry.booking.model.journey.Booking;
import ferry.booking.model.timetable.TimeTableEntry;
import ferry.booking.services.FerryAvailabilityService;
import ferry.booking.services.JourneyBookingService;
import ferry.booking.services.TimeTableService;
import ferry.booking.model.timetable.TimeTableViewModelRow;
import ferry.booking.model.timetable.TimeTableLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//TODO clean static methods
//TODO move view classes from services
public class Program {

    public static TimeTableService timeTableService;
    private static JourneyBookingService bookingService;
    public static List<Port> ports;
    private static FerryAvailabilityService ferryService;
    private static PrintStream out;

    public static void wireUp() throws IOException {
        List<Booking> bookings = new ArrayList<Booking>();
        ports = (new PortLoader()).load();
        List<TimeTableEntry> timetableEntries = new TimeTableLoader().load();
        ferryService = new FerryAvailabilityService(timetableEntries,ports, new FerryLoader().load());
        bookingService = new JourneyBookingService(timetableEntries, bookings, ferryService);
        timeTableService = new TimeTableService(timetableEntries, ports, bookings, ferryService);
    }

    public static void main(String[] args) {
        try {
            start(System.out);
            commandLoop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mainWithTestData(PrintStream ps) {

    }

    public static void start(PrintStream ps) throws IOException {
        out = ps;
        wireUp();

        out.println("Welcome to the Ferry Finding System");
        out.println("=======");
        out.println("Ferry Time Table");

        List<TimeTableViewModelRow> timeTable = timeTableService.getTimeTable(ports);

        displayTimetable(ports, timeTable);
    }


    public static void displayTimetable(List<Port> ports, List<TimeTableViewModelRow> rows) {
        for (Port port : ports) {
            printPortHeader(port.name);
            List<TimeTableViewModelRow> items = new ArrayList<TimeTableViewModelRow>();
            for (TimeTableViewModelRow x : rows) {
                if (x.originPort.equals(port.name)) {
                    items.add(x);
                }
            }
            Collections.sort(items, new Comparator<TimeTableViewModelRow>() {

                @Override
                public int compare(TimeTableViewModelRow tt1, TimeTableViewModelRow tt2) {
                    return tt1.startTime.compareTo(tt2.startTime);
                }
            });

            for (TimeTableViewModelRow item : items) {
                out.printf("| %-8s | %-13s | %-13s | %-18s | %-8s |", item.startTime, item.destinationPort,
                        item.journeyLength, item.ferryName, item.arrivalTime);
                out.println();
            }
        }
    }

    private static void commandLoop() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            line = br.readLine();
            while (line != "quit") {
                doCommand(line);

                line = (br.readLine()).toLowerCase();
            }
        } catch (IOException e) {
        }
    }

    public static void doCommand(String command) {
        if (command.startsWith("search")) {
            search(command);
        } else if (command.startsWith("book")) {
            book(command);
        } else if (command.startsWith("list ports")) {
            out.println("Ports:");
            out.println("------");
            for (Port port : ports) {
                out.printf("%d - %s", port.id, port.name);
                out.println();
            }
            out.println();
        } else if (command.startsWith("list bookings")) {
            List<Booking> bookings = bookingService.getAllBookings();
            out.println("Bookings:");
            out.println("---------");
            for (Booking b : bookings) {
                out.printf("journey %d - passengers %d", b.journeyId, b.passengers);
            }
            out.println();
        } else {
            out.println("Commands are: [search x y hh:mm] book, or list bookings");
            out.println("  search x y hh:mm");
            out.println("  book x y");
            out.println("  list bookings");
            out.println("  list ports");
            out.println();
            out.println("Book is [book x y]");
            out.println("where x - journey id");
            out.println("where y - number of passenger");
            out.println();
            out.println("Search is [search x y hh:mm]");
            out.println("where: x - origin port id");
            out.println("where: y - destinationg port id");
            out.println("where: hh:mm - time to search after");
        }
    }

    private static void book(String line) {
        try {
            String parts[] = line.split(" ");
            int journeyId = Integer.parseInt(parts[1]);
            int passengers = Integer.parseInt(parts[2]);

            if (bookingService.canBook(journeyId, passengers)) {
                Booking booking = new Booking();
                booking.journeyId = journeyId;
                booking.passengers = passengers;
                bookingService.book(booking);

                out.println("Booked");
            } else {
                out.println("Cannot book that journey");
            }
        } catch (Exception e) {
            out.println("Book is [book x y]");
            out.println("where x - journey id");
            out.println("where y - number of passenger");
        }
    }

    private static void search(String line) {
        try {
            String parts[] = line.split(" ");
            int originPortId = Integer.parseInt(parts[1]);
            int destinationPortId = Integer.parseInt(parts[2]);
            String mins[] = parts[3].split(":");
            long time = Long.parseLong(mins[0]) * 60 + Long.parseLong(mins[1]);

            List<AvailableCrossing> search = timeTableService.getAvailableCrossings(time, originPortId,
                    destinationPortId);

            for (AvailableCrossing result : search) {
                out.printf("[%02d:%02d] %s to %s -  %s (JourneyId : %d, spaces left %d)", result.setOff / 60,
                        result.setOff % 60, result.originPort, result.destinationPort, result.ferryName,
                        result.journeyId, result.seatsLeft);
                out.println();
            }
        } catch (Exception e) {
            out.println("Search is [search x y hh:mm]");
            out.println("where: x - origin port id");
            out.println("where: y - destinationg port id");
            out.println("where: hh:mm - time to search after");
        }
    }

    private static void printPortHeader(String portName) {
        out.println();
        out.println("Departures from " + portName);
        out.println();
        out.println(" --------------------------------------------------------------------------");
        out.printf("| %-8s | %-13s | %-13s | %-18s | %-8s |", "Time", "Destination", "Journey Time", "Ferry",
                "Arrives");
        out.println();
        out.println(" --------------------------------------------------------------------------");
    }
}
