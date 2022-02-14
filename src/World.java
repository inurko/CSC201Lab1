/**
 * The World class sets the valid region for rectangles.
 * It provides methods such as search, insert, remove, print,
 * find intersections, and find rectangles in a given region.
 */

import java.awt.Rectangle;
import java.util.*;

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


       /* if (!rect.intersects(WORLD_REC)){
            System.out.println("1");
        } if (rect.getWidth()==0){
            System.out.println("2");
        } if (rect.getHeight()==0){
            System.out.println("3");
        } if (rect.getWidth()> 1024){
            System.out.println("4");
        } if (rect.getHeight()>1024){
            System.out.println("5");
        } if(rect.getX()<0){
            System.out.println("6");
        } if (rect.getX()>1024){
            System.out.println("7");
        } if (rect.getY()<0){
            System.out.println("8");
        } if (rect.getY()>1024){
            System.out.println("9");
        }

        */
            if(! rect.intersects(WORLD_REC)|| rect.getWidth()==0||rect.getHeight()==0||rect.getWidth()> 1024||rect.getHeight()>1024||rect.getX()<0||rect.getX()>1024||rect.getY()<0||rect.getY()>1024)
        {
            return false;
        }

        if( ( (rect.getX() + rect.width) > 1024) || ((rect.getY() + rect.height)<0) || (rect.getY() + rect.height) > 1024 ){ //alkdkjsklsdksla
            return false;
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

                System.out.println("RECT " + rect);
                if (!(rect.getX() < region.getX() || rect.getX() > (region.getX() + region.getWidth()) || rect.getY() < region.getY() || rect.getY() < (region.getY() + region.getHeight())) || rect.intersects(region)) {
                    rectangles.add(hold.getRect());;
                }

            }}

            for (MyRectangle r : rectangles){
                System.out.println("Rectangle intersecting " + r.getRectangle().getX() + " " + r.getRectangle().getY() + " " + r.getRectangle().getWidth() + " " + r.getRectangle().getHeight());
            }
        }



                //check the intersection
    public void intersections() {

        ArrayList<Node<MyRectangle>> rectangleL = new ArrayList<Node<MyRectangle>>();
        Iterator<Node<MyRectangle>> iterator1 = tree.iterator();

        while (iterator1.hasNext()){
            rectangleL.add(iterator1.next());
                }

        for (int i = 0; i < rectangleL.size(); i++){
            Node<MyRectangle> hold1 = rectangleL.get(i);//current node in iteration
            Rectangle rect1 = hold1.getRect().getRectangle();  //current rectangle

            for (int j = i; j < rectangleL.size(); j++){
                boolean intersect = false;

                Node<MyRectangle> hold2 = rectangleL.get(j);
                Rectangle rect2 = hold2.getRect().getRectangle();//current rectangle

                if (hold1.getName().equals(hold2.getName())){
                    intersect = false;
                }
                else if (rect1.intersects(rect2)){
                    intersect = true;}

                if (intersect){
                    System.out.println(hold1 + "  : " + hold2); }
            }
        }




    }
    public void Dump()
    {
        System.out.println("BST dump:");
        if(tree.getHead()==null)
        {
            System.out.println("The node has depth 0, value (null)");
            return;
        }
        System.out.println("The node has depth 0, value " +tree.getHead().getRect());
        if(tree.getHead().getLeft()!=null){
            DumpHelper(tree.getHead().getLeft(),1 );
        }
        if(tree.getHead().getRight()!=null){
            DumpHelper(tree.getHead().getRight(),1 );
        }
        System.out.println("BST size is: "+tree.getSize());
    }
    public void DumpHelper(Node curr, int Depth)
    {
        System.out.print("The node has depth "+Depth+", value "+curr.getRect());
        if(curr.getLeft()!=null){
            DumpHelper(curr.getLeft(),Depth+1 );
        }
        if(curr.getRight()!=null){
            DumpHelper(curr.getRight(),Depth+1);
        }
        else
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
