package ferry.booking.model.timetable;

import java.io.IOException;
import java.util.*;

import ferry.booking.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

import static ferry.booking.Util.readFileToString;

public class TimeTableLoader {
    public TimeTableLoader() {
    }
    public List<TimeTableEntry> load() throws IOException {
        List<TimeTableEntry> entries = new ArrayList<>();
        loadEntries(entries);
        return setUpEntriesByIds(entries,Arrays.asList(1,2,3));
    }


    private  List<TimeTableEntry> setUpEntriesByIds(List<TimeTableEntry> entries, List<Integer> ids) {
        List<TimeTableEntry> selectedEntries = new ArrayList<>();
        for (Integer id: ids) {
            addEntriesById(entries, id, selectedEntries);
        }
        //TODO CHANGE WHEN IT WILL BE USED THE GET AND SETTERS
        Comparator<TimeTableEntry> byTime = (TimeTableEntry tte1, TimeTableEntry tte2)-> Long.compare(tte1.time, tte2.time);
        Collections.sort(selectedEntries, byTime);
        return selectedEntries;

    }

    private void addEntriesById(List<TimeTableEntry> entries, int id, List<TimeTableEntry> selectedEntries) {
        for (TimeTableEntry entry : entries) {
            if (entry.timeTableId == id) {
                entry.originId = id;
                selectedEntries.add(entry);
            }
        }
    }

    private void loadEntries(List<TimeTableEntry> entries) throws IOException {
        String json = readFileToString(Constants.PATH_TIMETABLE);
        JSONArray arr = new JSONArray(json);
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            TimeTableEntry tte = new TimeTableEntry();
            tte.id = obj.getInt("Id");
            tte.timeTableId = obj.getInt("TimeTableId");
            tte.originId = obj.getInt("OriginId");
            tte.destinationId = obj.getInt("DestinationId");
            tte.time = obj.getLong("Time");
            tte.journeyTime = obj.getLong("JourneyTime");
            entries.add(tte);
        }
    }

}
