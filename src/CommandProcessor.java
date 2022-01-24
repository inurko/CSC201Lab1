import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class read input files and parses each line of commands.
 * It determines the correct method to be called and
 * pass the rectangle infomation (rectangle names or coordinates).
 */

public class CommandProcessor {
    /**
     * Instantiates a new command processor
     */
    public CommandProcessor(String fileName) throws FileNotFoundException {
        World world = new World();
        run(new File(fileName));
    }

    /**
     * Read input file and parse each line of commands
     */
    public void run(File myFile) throws FileNotFoundException {

    }
}
