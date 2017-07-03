package ferry.booking;


import org.apache.commons.io.IOUtils;

import java.io.IOException;

//TODO trying to move this util antipattern
public class Util {
    public static String readFileToString(String path) throws IOException {
        return IOUtils.toString(Thread.currentThread().getClass().getResourceAsStream(path));
    }
}
