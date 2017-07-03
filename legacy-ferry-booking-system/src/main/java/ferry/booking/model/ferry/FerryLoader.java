package ferry.booking.model.ferry;

import ferry.booking.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ferry.booking.Util.readFileToString;

/**
 * Created by carlos on 4/13/17.
 */
public class FerryLoader {
    private String path;

    public FerryLoader() {
        this.path = Constants.PATH_FERRIES;
    }

    public List<Ferry> load() throws IOException {
        List<Ferry> ferries = new ArrayList<Ferry>();
        String json = readFileToString(path);
        JSONArray arr = new JSONArray(json);
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            Ferry f = new Ferry();
            f.id = obj.getInt("Id");
            f.name = obj.getString("Name");
            f.passengers = obj.getInt("Passengers");
            f.vehicles = obj.getInt("Vehicles");
            f.weight = obj.getDouble("Weight");
            f.homePortId = obj.getInt("HomePortId");
            ferries.add(f);
        }

        return ferries;
    }

}

