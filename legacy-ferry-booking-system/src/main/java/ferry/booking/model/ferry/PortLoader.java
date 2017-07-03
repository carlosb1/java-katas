package ferry.booking.model.ferry;

import ferry.booking.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ferry.booking.Util.readFileToString;

/**
 * Created by carlos on 4/17/17.
 */
public class PortLoader {
    public List<Port> load() throws IOException {
            List<Port> ports = new ArrayList<Port>();
            String json = readFileToString(Constants.PATH_PORTS);
            JSONArray arr = new JSONArray(json);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                Port p = new Port();
                p.id = obj.getInt("Id");
                p.name = obj.getString("Name");
                ports.add(p);
            }
        return ports;
    }
}
