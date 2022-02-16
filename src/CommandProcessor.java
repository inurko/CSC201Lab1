
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.security.InvalidParameterException;
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
            String methodCall = "";
            String argLine = scnr.nextLine(); //takes in first line from arg file
            argParser = new Scanner(argLine); //will parse through the line to get arguments

            while (argParser.hasNext()) {
                input = argParser.next();

                if(!input.equals(" ")){
                    if(args.isEmpty()){ methodCall = input;}
                    args.add(input);
                    argQ.add(input);
                }
            }

            switch (methodCall){
                case "insert":
                    if(args.size() == 6 ){
                        //System.out.println(argQ.remove());
                        argQ.remove();

                        // remove rectangle name from queue
                        String Name = argQ.remove();
                        //System.out.println(Name);
                        // create new rectangle object

                        Rectangle r1 = new Rectangle(Integer.parseInt(argQ.remove()),
                                Integer.parseInt(argQ.remove()),
                                Integer.parseInt(argQ.remove()),
                                Integer.parseInt(argQ.remove()));

                        // create new MyRectangle object
                        MyRectangle myRect = new MyRectangle(r1, Name);

                        // if the rectangle read is valid add it to binary tree, else reject and print
                        if (world.validRegion(r1)) {
                            world.tree.addRec(myRect, world.tree.getHead(), Name);
                            System.out.println("Rectangle accepted: " + myRect.toString());
                        } else {
                            System.out.println("Rectangle rejected: " + myRect.toString());
                        }
                        args.clear();

                    } else {
                        System.out.println("Invalid Insert Parameter Length: " + args.size());
                        args.clear();
                        argQ.clear();
                    }
                    break;

                case "regionsearch":
                    if (args.size() == 5){
                        //System.out.println("regionsearch");
                        argQ.remove();

                        Rectangle rectangleSearched = new Rectangle(Integer.parseInt(argQ.remove()), Integer.parseInt(argQ.remove()), Integer.parseInt(argQ.remove()), Integer.parseInt(argQ.remove()));
                        world.regionSearch(rectangleSearched);

                        args.clear();
                    } else {
                        System.out.println("Invalid Region Search Parameter Length: " + args.size());
                        args.clear();
                        argQ.clear();
                    }
                    break;

                case "intersections":
                    if (args.size() == 1){
                        System.out.println("Intersection pairs:");
                        world.intersections();
                        args.clear();
                    } else {
                        System.out.println("Invalid Intersections Parameter Length: " + args.size());
                        args.clear();
                        argQ.clear();
                    }break;


                case "dump":
                    if (args.size() == 1) {
                        world.Dump();
                        args.clear();
                        argQ.clear();
                    } else {
                        System.out.println("Invalid Dump Parameter Length: " + args.size());
                        args.clear();
                        argQ.clear();
                    }break;

                case "search":
                    if (((args.size() == 2) || (args.size() == 5)) && (args.get(0).equalsIgnoreCase("search"))) {
                        //System.out.println("search");
                        argQ.remove();
                        try {
                            String name = argQ.remove();
                            ArrayList<MyRectangle> a = world.tree.Locate(name);
                            if(a.isEmpty()){
                                System.out.println("Rectangle not found: " + name);
                            }
                            for (Object r : a) {
                                System.out.println("Rectangle found: " + r);
                            }
                        } catch (InvalidParameterException p) {
                            System.out.println(" Invalid Insert ");
                        }
                        args.clear();
                    }else {
                        System.out.println("Invalid Search Parameter Length: " + args.size());
                        args.clear();
                        argQ.clear();
                    }break;

                case "remove":
                    if ((args.size() == 2) || (args.size() == 5))  {
                        argQ.remove();
                        // removes first element from queue
                        String argInput = argQ.remove();
                        try {
                            int x = Integer.parseInt(argInput);
                            int y = Integer.parseInt(argQ.remove());
                            int w = Integer.parseInt(argQ.remove());
                            int h = Integer.parseInt(argQ.remove());
                            int initialSize = world.tree.getSize();
                            Rectangle removed = new Rectangle( x, y, w, h);//System.out.println("Removed: " + removed);
                            MyRectangle remove = new MyRectangle(removed);
                            world.tree.remove(remove);
                            int finalSize = world.tree.getSize();
                            if(initialSize == finalSize){
                                System.out.println("Rectangle rejected: (" + x + ", " + y + ", " + ", " + w + ", " + h + ")");
                            }


                            //call remove method
                        } catch (NumberFormatException e) {
                            // System.out.println("remove1");
                            ArrayList<MyRectangle> a = world.tree.Locate(argInput);
                            if(!a.isEmpty()) {
                                world.tree.remove(argInput);
                            }
                            else{
                                System.out.println("Rectangle rejected: " + argInput);
                            }
                        }

                        args.clear();
                    } else {
                        System.out.println("Invalid Remove Parameter Length: " + args.size());
                        args.clear();
                        argQ.clear();
                    }break;

                case "":
                    break;

                default:
                    System.out.println("Invalid Command. Please Check Again");
                    args.clear();
                    argQ.clear();
                    break;
            }
        }


    }
}