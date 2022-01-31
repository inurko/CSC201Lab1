import java.awt.*;
import java.util.Iterator;
import java.util.Stack;

/**
 * Implement a generic and iterable binary search tree,
 * and include methods such as locate, remove, and insert nodes.
 * You should also implement a generic BST iterator.
 */

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
            if (node.getRight()==null)
            {
                node.setLeft(newNode);
                size++;
            }
            else {
                addRec(rectangle, node.getLeft(), name);
            }
        }
    }
    public MyRectangle Locate(String name){
        BSTIterator iterator=new BSTIterator();
        while(iterator.hasNext())
        {
            Node hold = iterator.next();
            if(name.equals(hold.getName()))
            {
                return hold.getRect();
            }
        }
        return null;
    }
    public MyRectangle remove(String name)
    {
        BSTIterator iterator= new BSTIterator();
        head=null;
        MyRectangle r = null;
        while(iterator.hasNext())
        {
            Node hold = iterator.next();
            if(!(name.equals(hold.getName())))
            {
                addRec(hold.getRect(),head,hold.getName());
            }
            else if(name.equals(hold.getName()))
            {
                r=hold.getRect();
                size--;
            }
        }

        return r;

    }
    public MyRectangle remove(MyRectangle rectangle)
    {
        BSTIterator iterator= new BSTIterator();
        head=null;
        MyRectangle r = null;
        while(iterator.hasNext())
        {
            Node hold = iterator.next();
            if(!(rectangle.equals(hold.getRect())))
            {
                addRec(hold.getRect(),head,hold.getName());
            }
            else if(rectangle.equals(hold.getRect()))
            {
                r =hold.getRect();
                size--;
            }
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

    @Override
    public Iterator<Node<T>> iterator() {

        return bstIterator;
    }
}
