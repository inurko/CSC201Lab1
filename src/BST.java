import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * In this class, implement methods for your binary search tree,
 * such as locate nodes, remove nodes, and insert nodes.
 * You should also implement a generic and comparable iterator.
 */

public class BST <T extends Comparable <T>> implements Iterable<Node<T>> {
    private Node head;
    private int size;

    @Override
    public Iterator<Node<T>> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Node<T>> action) {

    }

    @Override
    public Spliterator<Node<T>> spliterator() {
        return null;
    }


    private class BSTIterator implements Iterator<Node<T>> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Node<T> next() {
            return null;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super Node<T>> action) {

        }
    }
    public static void addRec(MyRectangle rectangle,Node node, String name){

        Node newNode = new Node(rectangle, name);

        if (node==null)
        {
            newNode = node;
        }
        else if(newNode.compareTo(node)==1) {
            addRec(rectangle,node.getRight(), node.getName());
        }
        else if(newNode.compareTo(node)==-1) {
            addRec(rectangle,node.getLeft(), node.getName());
        }
    }
    public void Locate(MyRectangle rectangle,Node node){
        Node newNode= new Node(rectangle, null);
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
        MyRectangle rectangle = new MyRectangle(null);
        //How to seach and which side should i replace it with
        if(name.equals(node.getName()))
        {
            Node holdLeft = node.getLeft();
            Node holdRight = node.getRight();

        }

        return rectangle;
    }
    public MyRectangle remove(MyRectangle rectangle, Node node)
    {
        Node newNode= new Node(rectangle, null);
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

        return rectangle;
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
