
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

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
        //world = new World();
        run(new File(fileName));
    }

    /**
     * Read input file and parse each line of commands
     */
    public void run(File myFile) throws FileNotFoundException {


        /*
        String test = "1 2    23 4 5 ";
        String result = "";
        String input = "";
        Scanner testS = new Scanner(test);

        while (testS.hasNext()){
             input = testS.next();
            if(!input.equals(" ")){
                result += input;
            }
        }
        System.out.println("result: " + result);

         */

        FileInputStream file  = new FileInputStream(myFile);
        Scanner scnr = new Scanner(file);
        Scanner argParser;
        String input;
        ArrayList <String> args = new ArrayList<>();

        while (scnr.hasNext()){
            String argLine = scnr.nextLine(); //takes in first line from arg file

            argParser = new Scanner(argLine); //will parse through the line to get arguments

            while (argParser.hasNext()){
            input = argParser.next();

                if (! input.equals(" ")){
                    args.add(input);
                    System.out.println(input);
                }


            }

       }

    }
}
