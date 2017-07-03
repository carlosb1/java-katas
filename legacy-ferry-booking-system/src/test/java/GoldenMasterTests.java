import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import ferry.booking.Program;
import org.junit.Test;

public class GoldenMasterTests {

    //@Test
    public void generate_golden_master() {
        WriteToFile("master.txt");
    }

    private static void testCommands() {
        Program.doCommand("help");
        Program.doCommand("list ports");
        Program.doCommand("search 2 3 00:00");
        Program.doCommand("search 2 3 00:00");
        Program.doCommand("book 10 2");
        Program.doCommand("search 2 3 00:00");
        Program.doCommand("book 10 10");
        Program.doCommand("book 10 1");
        Program.doCommand("search 1 2 01:00");
        Program.doCommand("book 4 2");
        Program.doCommand("book 6 8");
        Program.doCommand("search 1 2 01:00");
        Program.doCommand("search 1 3 01:00");
        Program.doCommand("search 1 3 01:30");
        Program.doCommand("book 5 16");
        Program.doCommand("book 16 16");
        Program.doCommand("search 1 3 00:00");
        Program.doCommand("list bookings");
    }


    private static void WriteToFile(String fileName) {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new File(fileName));
            Program.start(ps);
            testCommands();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ps.close();
        }
    }

    private static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charset.defaultCharset());
    }

    //TODO change name, it doesnt follow any nomenclature
    @Test
    public void compare_to_golden_master() throws IOException {
        //TODO MOVE TO CONSTANTS
        WriteToFile("test-run.txt");
        String master = readFile("master.txt");
        String tests = readFile("test-run.txt");
        assertEquals(tests, master);
    }
}
