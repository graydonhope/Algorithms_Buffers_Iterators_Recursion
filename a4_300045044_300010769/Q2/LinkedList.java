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

import java.util.NoSuchElementException;
import java.util.*;

public class LinkedList<E> implements List<E> {
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
        * A reference to the previous node 
        */
        private Node<T> prev;
        /**
        * A reference to the next node
        */
        private Node<T> next;

        /**
        * Constructs a Node
        * @param value is the value to be stored in the node
        * @param prev is the previous node in the linked element of nodes
        * @param next is the next node in the linked element of nodes
        */

        private Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
    /**
    * The first element in the list 
    */
    private Node<E> head;

    /**
    * The number of elements in the list
    */
    private int size;

    /**
    * Constructs a linked list object
    */

    public LinkedList() {
        head = new Node<E>(null, null, null); // dummy node!
        head.prev = head.next = head;
        size = 0;
    }
    /**
    * An iterator goes through the whole linked list printing the values in it efficiently
    */

    private class LinkedListIterator implements Iterator<E> {

        /**
        * The node the iterator is currently pointing at
        */

        private Node<E> current = head;

        /**
        * The index the iterator is currently at
        */
        private int currentIndex = 0;


        /**
        * Returns true if a call to next will be successful 
        * @return true if calling next will succeed
        */
        public boolean hasNext() {
            return (current.next != head);
        }

        /**
        * Moves the iterator to the next element 
        * @throws NoSuchElementException if there is no 'next' element
        * @return returns the next element in the iterator
        */

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no next element");
            }

            current = current.next;
            currentIndex++;

            return current.value;
        }

        /**
        * Get the index of the element that would be returned by the subsequent call to the method next()
        */

        public int nextIndex(){
            return currentIndex;
        }
    }

    /**
    * Creates and returns an instance of a LinkedListIterator
    * @return an instance of a LinkedListIterator 
    */

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
    * Creates and returns an instance of a LinkedListIterator that begins are the specified index
    * @param nextIndex the index where the iterator will begin
    * @return an instance of a LinkedListIterator 
    * @throws IndexOutOfBoundsException if the index given is bigger than the list or negative
    */
    
    public Iterator<E> iterator(int nextIndex){
        if(nextIndex >= size || nextIndex < 0){
            throw new IndexOutOfBoundsException(nextIndex +  " is not a proper index");
        }

        Iterator<E> iterator = new LinkedListIterator();

        for(int i = 0; i < nextIndex; i++){
            iterator.next();

        }

        return iterator;
    }

    /**
    * Creates and returns an instance of a LinkedListIterator that begins at the same position as the index given in the parameter
    * @param other the first iterator that will be used to make a new iterator that begins at the same position
    * @return an instance of a LinkedListIterator 
    * @throws NullPointerException if the iterator is null
    */
    

    public Iterator<E> iterator(Iterator<E> other){
        if(other == null){
            throw new NullPointerException("Iterator is null");
        }
        Iterator<E> newIterator = new LinkedListIterator();
        int otherIndex = other.nextIndex();

        while(newIterator.nextIndex() != other.nextIndex()){
            newIterator.next();
        }

        return newIterator;
    }


    /**
    * Get the size of the list
    * @return returns the size of the list
    */
    public int size() {
        return size;
    }

    /**
    * Gets the object a the given index
    * @param index is the position where the object will be returned from
    * @return returns the object at the given index
    * @throws IndexOutOfBoundsException if the index given is negative or larger than the size of the list
    */
    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        Node<E> p = head.next;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.value;
    }

    /**
    *Adds the given object to the front of the list
    *@param elem is the element that will be added to the front of the list
    *@throws NullPointerException if the element given is null
    */

    public void addFirst(E elem) {

        if (elem == null) {
            throw new NullPointerException();
        }

        Node<E> second = head.next;

        head.next = new Node<E>(elem, head, second);
        second.prev = head.next;

        size++;
    }

    /**
    *Adds the given object to the end of the list
    *@param elem is the element that will be added to the list
    *@throws NullPointerException if the element given is null
    */

    public void add(E elem) {

        if (elem == null) {
            throw new NullPointerException();
        }

        Node<E> before = head.prev, after = head;

        before.next = new Node<E>(elem, before, after);
        after.prev = before.next;

        size++;
    }
    
}