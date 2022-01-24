package towerofhanoi;
import java.util.EmptyStackException;
import stack.StackInterface;
/**
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of 
//those who do.
//-- Aldiyar Bekturganov (aldiyarb)
 * 
 * This is the LinkedStack class that implements methods from
 * StackInterface and will be used as a way to store objects 
 * in the HanoiSolver Puzzle.
 * @author aldiyarb
 * @version (2020.03.25)
 * @param <T> The type of objects that the stack will hold.
 */
public class LinkedStack<T> implements StackInterface<T> {
    private int size;
    private Node<T> topNode;

    /**
     * LinkedStack constructor that initializes a new LinkedStack
     * object.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public LinkedStack() {
        topNode = new Node(null, null);
        size = 0;
    } 

    /**
     * Returns the size of the LinkedStack
     * @return returns the number of elements in the LinkedStack.
     */
    public int size() {
        return size; 
    } 

    /**
     * Returns the string representation of the LinkedStack.
     * @return Returns the string representation of the LinkedStack.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        Node<T> currentNode = topNode;

        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }
            builder.append(String.valueOf(currentNode.getData()));
            currentNode = currentNode.next;

        }
        builder.append(']');
        return builder.toString();
    }

    @Override
    /**
     * Clears the LinkedStack.
     */
    public void clear() {
        size = 0;
        topNode = null;

    }

    @Override
    /**
     * Returns true if the size of LinkedStack is 0. 
     * i.e it is empty
     * @return returns true if the size is 0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override 
    /**
     * Returns the data stored in the topNode. 
     * If the LinkedStack is empty throws an EmptyStackException.
     * @return Data in the topNode.
     */
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        else {
            return topNode.getData();
        }
    }

    @Override 
    /**
     * Removes the topNode. Then returns the data stored in it.
     * If the LinkedStack is empty throws an EmptyStackException.
     * @return Data in the topNode.
     */
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        else {
            T local = topNode.data;
            topNode = topNode.getNextNode();
            size--;
            return local;
        }
    }

    @Override
    /**
     * Adds a new Entry to the LinkedStack and increases 
     * LinkedStack's size.
     * @param anEntry an entry to be added to the LinkedStack
     */
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry);
        newNode.setNextNode(topNode);
        topNode = newNode;
        size++;
 
    }
    @SuppressWarnings({"hiding"})
    /**
     * Inner private class Node which will be data storages
     * in the LinkedStack
     * @author aldiyarb
     *
     * @param <T> The type of objects that the node will hold.
     */
    private class Node<T> {
        private Node<T> next;
        private T data;

        /**
         * Node constructor that takes the data it will store
         * as a parameter
         * @param data Data stored in this Node
         */ 
        public Node(T data) {
            this.data = data;
            this.next = null;
        } 

        /**
         * Node constructor that takes the data and the nextNode
         * it will be linked to as parameters
         * @param data Data stored in this Node
         * @param nextNode The next node that this Node will be 
         * linked to
         */
        public Node(T data, Node<T> nextNode) {
            this.data = data;
            this.next = nextNode;

        }

        /**
         * This method returns the next node from this node.
         * @return Next node linked to this node
         */
        public Node<T> getNextNode() {
            return this.next;

        }

        /**
         * This method returns the data stored in this node.
         * @return Data stored in this node.
         */
        public T getData() {
            return this.data;

        }

        /**
         * This method sets the next node of this node. 
         * @param nextNode Next node set to this node.
         */
        public void setNextNode(Node<T> nextNode) {
            this.next = nextNode;
        } 

    }

}
