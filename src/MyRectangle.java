/**
 * This class implement the rectangle node with standard getters and setters
 * Note that compareTo method should be designed here. 
 */

import java.awt.*;

import java.awt.*;

public class MyRectangle implements Comparable<MyRectangle> {
    private Rectangle rectangle;

    public MyRectangle(Rectangle rectangle){
        this.rectangle=rectangle;
    }
    public int compareTo(MyRectangle rectangle1)
    {
        if(rectangle1.getRectangle().equals(rectangle)) {
            return 0;
        }
        else if(rectangle.getWidth()*rectangle.getHeight()>rectangle1.getRectangle().getHeight()*rectangle1.getRectangle().getWidth())
            return 1;
        else{
            return-1;
        }
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public String toString(){
        return " " + rectangle;
    }

}
