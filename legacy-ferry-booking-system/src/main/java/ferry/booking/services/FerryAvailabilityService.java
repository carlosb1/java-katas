package ferry.booking.services;

import ferry.booking.model.ferry.*;
import ferry.booking.model.timetable.TimeTableEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FerryAvailabilityService {
    private  List<PortModel> ports;
    private List<Port> availablePorts;
    private List<Ferry> ferries;
    private List<TimeTableEntry> allEntries;
    public FerryAvailabilityService(List<TimeTableEntry> allEntries, List<Port> availablePorts, List<Ferry> ferries) throws IOException {
        this.allEntries = allEntries;
        this.availablePorts = availablePorts;
        this.ferries = ferries;
    }

    private List<PortModel> setUpPortModels() {
        List<PortModel> allPorts = new ArrayList<>();
        for (Port port : availablePorts) {
            allPorts.add(new PortModel(port));
        }
        for (Ferry ferry : ferries) {
            for (PortModel port : allPorts) {
                //TODO check visibilIty parameters
                if (port.id == ferry.homePortId) {
                    port.addBoat(10, ferry);
                }
            }
        }
        return allPorts;
    }


    //TODO apply functional for this comparator
    public Ferry nextFerryAvailableFrom(int portId, long time) {
        ports = setUpPortModels();
        for (TimeTableEntry entry : allEntries) {
            FerryJourney ferry = FerryManager.createFerryJourney(ports, entry);
            if (ferry != null) {
                boatReady(entry, ferry.destination, ferry);
            }
            if (entry.originId == portId) {
                if (entry.time >= time) {
                    if (ferry != null) {
                        return ferry.ferry;
                    }
                }
            }
        }
        //TODO avoid return null
        return null;
    }

    private static void boatReady(TimeTableEntry timetable, PortModel destination, FerryJourney ferryJourney) {
        if (ferryJourney.ferry == null) {
            FerryManager.addFerry(timetable, ferryJourney);
        }
        Ferry ferry = ferryJourney.ferry;

        long time = FerryModule.timeReady(timetable, destination);
        destination.addBoat(time, ferry);
    }
}
