import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * In this class, implement methods for your binary search tree,
 * such as locate nodes, remove nodes, and insert nodes.
 * You should also implement a generic and comparable iterator.
 */

public class BST <T extends Comparable <T>> implements Iterable<Node<T>> {
    private Node head;
    private int size;


    private class BSTIterator implements Iterator<Node<T>> {
    }
    public void addRec(MyRectangle rectangle,Node node){
        Node newNode= new Node(rectangle);
        if (node==null)
        {
            node=newNode;
        }
        else if(newNode.compareTo(node)==1) {
            addRec(rectangle,node.getRight());
        }
        else if(newNode.compareTo(node)==-1) {
            addRec(rectangle,node.getLeft());
        }
    }
    public void Locate(MyRectangle rectangle,Node node){
        Node newNode= new Node(rectangle);
        if (newNode.compareTo(node)==0)
        {
            node=newNode;
        }
        else if(newNode.compareTo(node)==1) {
            Locate(rectangle,node.getRight());
        }
        else if(newNode.compareTo(node)==-1) {
            Locate(rectangle,node.getLeft());
        }

        //What do I return?
    }
    public MyRectangle remove(String name, Node node)
    {
        //How to seach and which side should i replace it with
        if(name.equals(node.getName()))
        {
            Node holdLeft = node.getLeft();
            Node holdRight = node.getRight();

        }


    }
    public MyRectangle remove(MyRectangle rectangle, Node node)
    {
        Node newNode= new Node(rectangle);
        if (newNode.compareTo(node)==0)
        {
            node=newNode;
        }
        else if(newNode.compareTo(node)==1) {
            Locate(rectangle,node.getRight());
        }
        else if(newNode.compareTo(node)==-1) {
            Locate(rectangle,node.getLeft());
        }


    }

    public Node getHead() {
        return head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
