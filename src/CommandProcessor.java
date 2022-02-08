
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

                    b.addRec(myRect, b.getHead(), Name);


                    break;

                case "remove":

                    System.out.println("tree before remove: "); b.printTree(b.getHead());

                    String argInput = argQ.remove();
                    try {
                        int x = Integer.parseInt(argInput);
                        System.out.println("remove2");
                        Rectangle removed = new Rectangle( x, Integer.parseInt(argQ.remove()), Integer.parseInt(argQ.remove()), Integer.parseInt( argQ.remove()));
                        System.out.println("Removed: " + removed);
                        MyRectangle remove = new MyRectangle(removed);
                        b.remove(remove);
                        System.out.println("tree after remove: "); b.printTree(b.getHead());



                        //call remove method
                    } catch (NumberFormatException e) {
                        System.out.println("remove1");
                        b.remove(argInput);
                        //call other remove method
                    }

                    break;

                 /*       if (argQ.peek().getClass().g.equals("StrietSimpleName()ng")) {
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

/*

                case "regionsearch":
                    argQ.remove();
                    argQ.remove();
                    argQ.remove();
                    argQ.remove();
              //      System.out.println("regionsearch");
                    break;

                case "intersections":
                 //   System.out.println("intersections");

*/
                case "dump":
                    break;


                case "search":
                    System.out.println("search");
                    ArrayList<MyRectangle> a = b.Locate(argQ.remove());
                    for (Object r: a){
                        System.out.println("r: " + r);
                    }
                    break;

            }

          //  System.out.println(" head :" + b.getHead());
           // System.out.println(" size :" + b.getSize());






        }


    }
    }

