
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * This class read input files and parses each line of commands.
 * It determines the correct method to be called and
 * pass the rectangle infomation (rectangle names or coordinates).
 */

public class CommandProcessor {

    World world;
    /**
     * Instantiates a new command processor
     */
    public CommandProcessor(String fileName) throws FileNotFoundException {
        world = new World();
        run(new File(fileName));
    }

    /**
     * Read input file and parse each line of commands
     */
    public void run(File myFile) throws FileNotFoundException {

        // opens file and creates necessary variables
        FileInputStream file = new FileInputStream(myFile);
        Scanner scnr = new Scanner(file);
        Scanner argParser;
        String input;
        ArrayList<String> args = new ArrayList<>();
        Queue<String> argQ = new LinkedList<String>();

        // goes through file while there is another line
        while (scnr.hasNext()) {
            String argLine = scnr.nextLine(); //takes in first line from arg file
            argParser = new Scanner(argLine); //will parse through the line to get arguments

            // while there is another string, reads into input string
            while (argParser.hasNext()) {
                input = argParser.next();

                if (!input.equals(" ")) {
                    args.add(input);
                    argQ.add(input);
                }
            }
        }

        int i = 0;

        // while the queue still has elements
        while (!argQ.isEmpty()) {
            // take the first element (method instruction)
            String s = argQ.remove();

            switch (s) {

                case "insert":
                    System.out.println("                     ");
                    System.out.println("insert");

                    // remove rectangle name from queue
                    String Name = argQ.remove();

                    // create new rectangle object
                    Rectangle r1 = new Rectangle(Integer.parseInt(argQ.remove()),
                            Integer.parseInt(argQ.remove()),
                            Integer.parseInt(argQ.remove()),
                            Integer.parseInt(argQ.remove()));

                    // create new MyRectangle object
                    MyRectangle myRect = new MyRectangle(r1, Name);

                    // if the rectangle read is valid add it to binary tree, else reject and print
                    if (world.validRegion(r1)){
                        world.tree.addRec(myRect, world.tree.getHead(), Name);
                        System.out.println("Rectangle accepted: " + myRect.toString());
                    }
                    else { System.out.println("Rectangle Rejected: " + myRect.toString());  }

                    break;

                case "remove":
                    // removes first element from queue
                    String argInput = argQ.remove();

                    try {

                        int x = Integer.parseInt(argInput);
                        System.out.println("remove2");
                        Rectangle removed = new Rectangle( x, Integer.parseInt(argQ.remove()), Integer.parseInt(argQ.remove()), Integer.parseInt( argQ.remove()));
                        System.out.println("Removed: " + removed);
                        MyRectangle remove = new MyRectangle(removed);
                        world.tree.remove(remove);


                        //call remove method
                    } catch (NumberFormatException e) {
                        System.out.println("remove1");
                        world.tree.remove(argInput);
                        //call other remove method
                    }

                    break;

                case "dump":
                    System.out.println("dump read");
                    break;


                case "search":
                    System.out.println("search");
                    ArrayList<MyRectangle> a = world.tree.Locate(argQ.remove());
                    for (Object r: a){
                        System.out.println("r: " + r);
                    }
                    break;

                case "regionsearch":
                    System.out.println("regionsearch");
                    Rectangle rectangleSearched = new Rectangle(Integer.parseInt(argQ.remove()), Integer.parseInt(argQ.remove()), Integer.parseInt(argQ.remove()), Integer.parseInt(argQ.remove()));
                    world.regionSearch(rectangleSearched);
                    break;

                case "intersections":
                    System.out.println("intersections");
                    //world.intersections();

            }
        }
    }
    }