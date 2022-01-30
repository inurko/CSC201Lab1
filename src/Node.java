import java.awt.*;
import java.util.Objects;

/**
 * Implement a generic and comparable Node class
 * that contains a set of constructors,
 * getter, and setters for the BST.
 */

public class Node<T extends Comparable<T>> {
    private Node left, right;
    private MyRectangle rect;
    private String name;

    public Node(Node n){
        rect = n.rect;
        left = n.left;
        right = n.right;
        name = n.name;
    }
    public Node(MyRectangle curr, String name) {
        rect = curr;
        left = null;
        right = null;
        name = null;
    }

    public Node(MyRectangle curr, Node L, Node R, String name) {
        rect = curr;
        left = L;
        right = R;
        this.name = name;
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

    public int compareTo(Node node) {
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

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}


