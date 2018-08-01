/*  Student information:
    STUDENT 1:                                    
    Last name: Gagbegnon                                   
    First name: Santos                                       
    Student #: 300010769                                     
    Section: C    

    STUDENT 2:                                               
    Last name: Hope                                          
    First name: Graydon                                      
    Student #: 300045044                                      
    Section: C   
*/  
/**
*  @author Marcel Turcotte
*/

import java.util.NoSuchElementException;

public class BinarySearchTree<E extends Comparable<E>> {
    /**
    * The class Node are linked elements that store a value of type 'E' and contain 
    * a 'next' instance variable that points to the next Node in the linked sequence and a previous that points to the Node behind it
    */
    private static class Node<T> {
        /**
        * The value stored inside of the node 
        */
        private T value;
        /**
        * The node that is less than the instance node above it
        */
        private Node<T> left;

        /**
        *The node that is greater than the instance node
        */
        private Node<T> right;

        /**
        * Constructs a node with the given value
        * @param value the value to be stored in the node instance
        */
        private Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
    * The first element in the binary search tree
    */
    private Node<E> root = null;
    /**
    * Recursively counts the amount of items in between low and high (inclusive)
    * @param low the lower bound of the search
    * @param high the upper bound of the search
    * @return the number of elements in between the lower and upper bound (inclusive)
    * @throws NullPointerException if the high or low value is null
    * @throws IllegalArgumentException is the value of high is lower than the low value
    */

    public int count(E low, E high){
        if(low == null || high == null){
            throw new NullPointerException("Low or high can't be null");
        }

        if(low.compareTo(high) == 1){
            throw new IllegalArgumentException("High is less than low ");
        }
        return count(low, high, root,0);
    }
    
    private int count(E low, E high, Node<E> current, int count){
        if(current.right == null && current.left == null){
            if(!((low.compareTo(current.value) == 1) || (high.compareTo(current.value) == -1))){
                count++;
            }
            return count;
        }

        if(current.right != null && high.compareTo(current.value) >= 0){
            if(!((low.compareTo(current.value) == 1) || (high.compareTo(current.value) == -1))){
                count++;
            }
            count = count(low,high,current.right,count);
        }

        if(current.left != null && low.compareTo(current.value) <= 0){
            if(!((low.compareTo(current.value) == 1) || (high.compareTo(current.value) == -1)) && current.right == null){
                count++;
            }
            count = count(low,high, current.left, count);
        }
        return count;
    }
 
    /**
    * Inserts an object into this BinarySearchTree.
    *
    * @param elem item to be added
    * @return true if the object has been added and false otherwise
    */

    public boolean add(E elem) {

        // pre-condtion:

        if (elem == null) {
            throw new NullPointerException();
        }

        // special case:

        if (root == null) {
            root = new Node<E>(elem);
            return true;
        }

        // general case:

        return add(elem, root);
    }

    // Helper method

    private boolean add(E elem, Node<E> current) {

        boolean result;
        int test = elem.compareTo(current.value);

        if (test == 0) {
            result = false; // already exists, not added
        } else if (test < 0) {
            if (current.left == null) {
                current.left = new Node<E>(elem);
                result = true;
            } else {
                result = add(elem, current.left);
            }
        } else {
            if (current.right == null) {
                current.right = new Node<E>(elem);
                result = true;
            } else {
                result = add(elem, current.right);
            }
        }
        return result;
    }
    /**
    * Presents a string representation of the binary search tree
    * @return returns the string representation of the binary search tree
    */
    public String toString() {
        return toString(root);
    }
   //Helper method

    private String toString(Node<E> current) {

        if (current == null) {
            return "()";
        }

        return "(" + toString(current.left) + current.value + toString(current.right) + ")";
    }

}