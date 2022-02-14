import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Implement a generic and iterable binary search tree,
 * and include methods such as locate, remove, and insert nodes.
 * You should also implement a generic BST iterator.
 **/

public class BST <T extends Comparable <T>> implements Iterable<Node<T>> {
    private Node head;
    private int size;
    private BSTIterator bstIterator;

    private class BSTIterator implements Iterator<Node<T>> {

        private Stack<Node> previousNodes;

        private Node current;

        public BSTIterator()
        {
            previousNodes=new Stack<>();
            fillStack(head);
            current=head;
        }

        public void fillStack(Node node)
        {
            if(node==null) {
                return;
            }
           fillStack(node.getLeft());
            previousNodes.push(node);
            fillStack(node.getRight());
        }

        public boolean hasNext(){
         return !previousNodes.isEmpty();
        }

        public Node next()
        {
            return previousNodes.pop();
        }
    }

    public void addRec(MyRectangle rectangle,Node node, String name){
        Node newNode= new Node(rectangle, name);

            if(head==null)
            {
                head = new Node(newNode);
                size++;
            }


         else if(newNode.compareTo(node)==1) {
            newNode.setPrevious(node);
            if(node.getRight()==null)
            {
                node.setRight(newNode);
                size++;
            }
            else {
                addRec(rectangle, node.getRight(), name);
            }

        }
        else if(newNode.compareTo(node)==-1) {
            newNode.setPrevious(node);
            if (node.getLeft()==null)
            {
                node.setLeft(newNode);
                size++;
            }
            else {
                addRec(rectangle, node.getLeft(), name);
            }
        }
        else{

                node.setLeft(newNode);
            //addRec(rectangle, node.getLeft(), name); //if the nodes are the same it adds on the left
        }
    }

    public ArrayList<MyRectangle> Locate(String name) {
        BSTIterator iterator = new BSTIterator();
        ArrayList<MyRectangle> rectangles = new ArrayList<>();
        while (iterator.hasNext()) {
            Node hold = iterator.next();
            if (name.equals(hold.getName())) {
                rectangles.add(hold.getRect());
            }
        }
        return rectangles;
    }

    public MyRectangle remove(String name)
    {
        BSTIterator iterator= new BSTIterator();
        size = 0;
        head=null;
        MyRectangle r = null;

        while(iterator.hasNext())
        {

            Node hold = new Node(iterator.next());

            if(!(name.equals(hold.getName())))
            {
                addRec(hold.getRect(),head,hold.getName()); //change head to hold?
            }
            else if(name.equals(hold.getName()))
            {
                r=hold.getRect();

            }

        }
        return r;
    }

    public MyRectangle remove(MyRectangle rectangle)
    {
        BSTIterator iterator= new BSTIterator();
        size = 0;
        head=null;
        MyRectangle r = null;
        while(iterator.hasNext())
        {
            Node hold = new Node (iterator.next());

            if(rectangle.getRectangle().getX()!=hold.getRect().getRectangle().getX()||rectangle.getRectangle().getY()!=hold.getRect().getRectangle().getY()||rectangle.getRectangle().getHeight()!=hold.getRect().getRectangle().getHeight()||rectangle.getRectangle().getWidth()!=hold.getRect().getRectangle().getWidth())
            {
                addRec(hold.getRect(),head,hold.getName());
            }
            else
            {
                r=hold.getRect();
            }
        }
        return r;
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

    public void printTree(Node node){

        if (node == null){
            return;
        }
        else{
            printTree (node.getLeft());
            System.out.println("Node: " + node);
            printTree(node.getRight());}

        
        
    }

    @Override
    public Iterator<Node<T>> iterator() {
        bstIterator=new BSTIterator();
        return bstIterator;
    }



}
