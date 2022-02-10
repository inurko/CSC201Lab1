/**
 * The World class sets the valid region for rectangles.
 * It provides methods such as search, insert, remove, print,
 * find intersections, and find rectangles in a given region.
 */

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class World {
    //set up the range and points for the whole world
    public static final  int WORLD_WIDTH = 1024;
    public static final int WORLD_HEIGHT = 1024;
    public static final int ORIGIN_X = 0;
    public static final int ORIGIN_Y = 0;
    public static final Rectangle WORLD_REC = new Rectangle(0, 0, 1024, 1024);
    protected BST<MyRectangle> tree;
    public World(){
        tree = new BST<>();
    }

    //check if the rectangle is inside the range of the World
    //check if the rectangle is inside the range of the World
    public boolean validRegion(Rectangle rect){

        if(rect.intersects(WORLD_REC)|| rect.getWidth()==0||rect.getHeight()==0||rect.getWidth()> 1024||rect.getHeight()>1024||rect.getX()<0||rect.getX()>1024||rect.getY()<0||rect.getY()>1024)
        {
     //       return false;
        }
        return true;
    }

    //region search for rectangle
    public void regionSearch(Rectangle region) {
        ArrayList<MyRectangle> rectangles=new ArrayList<>();//Holds all the rectangles in the region
        if(region.getHeight()==0||region.getWidth()==0)
        {
            System.out.println("rectangle bad");
            return;
        }
        else{
            Iterator<Node<MyRectangle>> iterator = tree.iterator();//A loop in the array

            while (iterator.hasNext()) {
                Node<MyRectangle> hold = iterator.next();//current node in iteration
                Rectangle rect = hold.getRect().getRectangle();//current rectangle
                if (!(rect.getX() < region.getX() || rect.getX() > (region.getX() + region.getWidth()) || rect.getY() < region.getY() || rect.getY() < (region.getY() + region.getHeight())) || rect.intersects(region)) {
                    rectangles.add(hold.getRect());;
                }

            }}

            for (MyRectangle r : rectangles){
                System.out.println("Rectangle intersecting " + r.getRectangle().getX() + " " + r.getRectangle().getY() + " " + r.getRectangle().getWidth() + " " + r.getRectangle().getHeight());
            }
        }



                //check the intersection
    public void intersections(Rectangle rect) {
        ArrayList<MyRectangle> rectangles=new ArrayList<>();//Holds all the rectangles in the region
        Iterator<Node<MyRectangle>> iterator;
        if(rect.getHeight()==0||rect.getWidth()==0)
        {
            System.out.println("rectangle bad");
            return;
        } else {
                    iterator = tree.iterator();

        }
                return;



    }


    //remove by the content of the rectangle
    public MyRectangle remove(MyRectangle rect) {
        return tree.remove(rect);
    }


    //remove by the name of the rectangle
    public MyRectangle remove(String name) {
        return tree.remove(name);
    }


}
