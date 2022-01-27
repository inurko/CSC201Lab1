import java.awt.*;
import java.util.Objects;

/**
 * Implement a generic and comparable Node class
 * that contains a set of constructors,
 * getter, and setters for the BST.
 */

public class Node<T extends Comparable<T>> {
    private Node left,right;
    private MyRectangle rect;
    private String name;
    public Node(MyRectangle curr) {
        rect=curr;
        left=null;
        right=null;
    }
    public Node(MyRectangle curr, Node L, Node R,String Name)
    {
        rect=curr;
        left=L;
        right=R;
        this.name=Name;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public MyRectangle getRect() {
        return rect;
    }

    public int compareTo(Node node)
    {
        return rect.compareTo(node.getRect());
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setRect(MyRectangle rect) {
        this.rect = rect;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
