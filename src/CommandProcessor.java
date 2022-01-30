
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

        FileInputStream file = new FileInputStream(myFile);
        Scanner scnr = new Scanner(file);
        Scanner argParser;
        String input;
        ArrayList<String> args = new ArrayList<>();
        Queue<String> argQ = new LinkedList<String>();
        BST b = new BST();

        while (scnr.hasNext()) {
            String argLine = scnr.nextLine(); //takes in first line from arg file

            argParser = new Scanner(argLine); //will parse through the line to get arguments

            while (argParser.hasNext()) {
                input = argParser.next();

                if (!input.equals(" ")) {
                    args.add(input);
                    argQ.add(input);

                }
            }
        }
        int i = 0;

        while (!argQ.isEmpty()) {
            String s = argQ.remove();

            switch (s) {

                case "insert":
                    System.out.println("insert");

                    String Name = argQ.remove();

                    Rectangle r1 = new Rectangle(Integer.parseInt(argQ.remove()),
                            Integer.parseInt(argQ.remove()),
                            Integer.parseInt(argQ.remove()),
                            Integer.parseInt(argQ.remove()));

                    MyRectangle myRect = new MyRectangle(r1);
                    Node node = new Node(myRect, Name);
                    b.addRec(myRect, node, node.getName());
                    break;

                case "remove":
                    String argInput = argQ.remove();
                    try {
                        int x = Integer.parseInt(argInput);
                        argQ.remove();
                        argQ.remove();
                        argQ.remove();
                        System.out.println("remove2");
                        //call remove method
                    } catch (NumberFormatException e) {
                        System.out.println("remove1");
                        //call other remove method
                    }

                    break;

                 /*       if (argQ.peek().getClass().getSimpleName().equals("String")) {
                            argQ.remove();
                          System.out.println("remove1");

                            System.out.println("next elements: " + argQ.remove() + " 2 " + argQ.peek());

                            System.out.println(argQ.peek().getClass().getSimpleName());
                        }
                        else {
                            argQ.remove();
                            argQ.remove();
                            argQ.remove();
                            argQ.remove();
                            System.out.println("remove2");
                        }

                  */

                case "regionsearch":
                    argQ.remove();
                    argQ.remove();
                    argQ.remove();
                    argQ.remove();
                    System.out.println("regionsearch");
                    break;

                case "intersections":
                    System.out.println("intersections");


                case "dump":
                    System.out.println("dump");


                case "search":
                    argQ.remove();
                    System.out.println("search");
                    break;

            }


        }


    }
    }

