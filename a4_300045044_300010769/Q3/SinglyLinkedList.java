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
import java.util.*;

public class SinglyLinkedList<E> implements List<E>, Iterable<E> {

    /**
    * Counts the distance from the first instance of fromElement to the first instance of toElement
    * @param fromElement is the first element in the distance
    * @param toElement is the last element in the distance
    * @return returns the distance from fromElement to toElement
    */

    public int count(E fromElement, E toElement) {
        Node<E> position = get(head, fromElement);
        if(position == null){
            return 0;
        }
        return find(position,toElement,0);
    }
    /* HELPER METHOD
    * A recursive method that will return the node corresponding to the given object
    * @param start where the search will begin
    * @param elem is the element to be found
    * @return returns the Node corresonding to the given object
    * @throws NullPointException if start is null
    */

    private Node<E> get(Node<E> start, E elem){
        Node<E> foundNode;

        if(start == null){
            throw new NullPointerException("Start cannot be null");
        }
        if(start.value.equals(elem)){
            return start;
        }
        if(start.next == null){
            return null;
        }
        else {
            Node<E> next = start.next;
            foundNode = get(next, elem);
        }
        return foundNode;
    }

    /* Helper method
    * A recursive method that will return the index of the given object
    * @param start where the search will begin
    * @param elem is the element to be found
    * @param count is index the method is currently at
    * @return returns the Node corresonding to the given object
    * @throws NullPointException if start is null
    */

    private int find(Node<E> start, E elem, int count){
        int finalCount = 0;
        if(start == null){
            throw new NullPointerException("Start cannot be null");
        }

        if(start.value.equals(elem)|| start.next == null){
            return count+1;
        }

        else{
            count++;
            Node<E> next = start.next;
            finalCount = find(next,elem,count);
        }

        return finalCount;
        
    }
     /**
    * The class Node are linked elements that store a value of type 'E' and contain 
    * a 'next' instance variable that points to the next Node in the linked sequence
    */
    private static class Node<T> {
        /**
        * The value stored inside of the node 
        */
        private T value;

        /**
        * A reference to the next node 
        */
        private Node<T> next;

        /**
        * Constructs a Node
        * @param value is the value to be stored in the node
        * @param next is the next node in the linked element of nodes
        */
        private Node(T value, Node<T> next ) {
            this.value = value;
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator<E> {

        /**
        * the current Node the iterator is pointing too
        */
        private Node<E> currentIterator;

        /**
        * Constructs a LinkedListIterator
        */

        public LinkedListIterator() {
            currentIterator = null;
        }

        /**
        * Moves the iterator to the next element 
        * @throws NoSuchElementException if there is no 'next' element
        * @return returns the next element in the iterator
        */

        public E next() {
            if(currentIterator == null) {
                currentIterator = head;
            } else {
                currentIterator = currentIterator.next;
            }
            if(currentIterator == null)
            throw new NoSuchElementException("Iterator at the end or list empty");
            return currentIterator.value;
        }

        /**
        * Determine if the iterator has a next item to iterate to
        * @return returns true if a call to next will work, false if otherwise
        */

        public boolean hasNext(){
            if(currentIterator == null)
            return !isEmpty();
            else
            return (currentIterator.next != null);
        }

        /**
        * @throws UnsupportedOperationException because it has not been implemented.
        */
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
    /**
    * Returns a new LinkedListIterator object 
    */

    public Iterator<E> iterator(){
        return new LinkedListIterator();
    }

    /**
    * The first element in the list 
    */
    private Node<E> head;
    /**
    * The size of the list
    */
    private int size;

    /**
    * The last element in the list
    */
    private Node<E> tail;

    /**
    * Constructs a SinglyLinkedList
    */

    public SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    /**
    * Get the size of the list
    * @return the size of the list
    */
    public int size() {
        return size;
    }

    /**
    * Determines if the list is empty
    * @return true if list is empty, false otherwise 
    */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
    * Adds the given element to the list to the first position
    * @param o is the element to be added to the list
    * @throws NullPointerException if you try to add a null reference to the list
    */
    public void addFirst(E o) {

        if(o == null) {
            throw new NullPointerException("Can't add null reference to the list");
        }
        Node<E> newNode = new Node<E>( o, null );
        if ( head == null ) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
    * Adds the element to the end of the list
    * @param o is the element to be added to the list
    * @throws NullPointerException if you try to add a null reference to the list
    */
    public void add( E o ) {

        if(o == null) {
            throw new NullPointerException("Can't add null reference to the list");
        }
        Node<E> newNode = new Node<E>( o, null );
        if ( head == null ) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
    * Adds the given object at the given index
    * @param pos is the index where the item will be added
    * @param o is the element that will be added to the list
    * @throws NullPointerException if you try to add a null reference to the list
    */
    public void add( int pos, E o) {

        if(o == null) {
            throw new NullPointerException("Can't add null reference to the list");
        }
        if ( pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException( Integer.toString( pos ) );
        }


        if(pos == 0){
            addFirst( o );
        } else if(pos == size){
            add( o );
        } else  {

            Node<E> p = head;
            for(int i = 0; i < pos - 1; i++) {
                p = p.next;
            }

            p.next = new Node<E>( o, p.next );
            size++;
        }
    }

    /**
    * removes the first element in the lsit
    * @return returns the element just removed
    * @throws IllegalStateException if the list is empty
    */
    public E removeFirst() {

        if(isEmpty())
        throw new IllegalStateException("Empty list!");

        E savedValue = head.value;
        size--;
        if(size > 0){
            head = head.next;
        } else {
            head = tail = null;
        }
        return savedValue;
    }

    /**
    * removes the last element in the lsit
    * @return returns the element just removed
    * @throws IllegalStateException if the list is empty
    */
    public E removeLast() {

        if(isEmpty())
        throw new IllegalStateException("Empty list!");

        E savedValue= tail.value;

        if ( head.next == null ) {
            head = tail = null;
        } else {
            Node<E> p = head;
            while ( p.next != tail ) {
                p = p.next;
            }
            tail = p;
            tail.next = null;
        }
        size--;
        return savedValue;
    }

    /**
    * removes the given element from the list
    * @param o the object to be removed
    * @return returns true if the element was removed and false otherwise 
    * @throws NullPointerException if the element given is null
    */
    public boolean remove( E o ) {

        if ( head == null )
        return false;

        if ( head.value.equals( o ) ) {
            removeFirst();
            return true;
        } else {
            Node<E> p = head;
            while ( p.next != null && ! p.next.value.equals( o ) ) {
                p = p.next;
            }
            if ( p.next == null ) {
                return false;
            } else {
                p.next = p.next.next;
                if(p.next == null) {
                    tail = p;
                }
                size--;
                return true;
            }
        }
    }

    /**
    * Gets the object a the given index
    * @param pos is the position where the object will be returned from
    * @return returns the object at the given index
    * @throws IllegalStateException if the list is empty 
    * @throws IndexOutOfBoundsException if the given position is out of bounds
    */
    public E get( int pos ) {

        if(isEmpty())
        throw new IllegalStateException("Empty list!");

        if ( pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException( Integer.toString( pos ) );
        }

        Node<E> p = head;

        for ( int i=0; i<pos; i++ ) {
            p = p.next;
        }

        return p.value;
    }

    /**
    * Removes the object at the given index
    *@param pos is the position at which the object will be removed 
    *@return returns the object that was removed
    *@throws IllegalStateException if the list is empty
    *@throws IndexOutOfBoundsException if the given position is out of bounds
    */
    public E remove( int pos ) {

        if(isEmpty())
        throw new IllegalStateException("Empty list!");

        if ( pos < 0 || pos >= size ) {
            throw new IndexOutOfBoundsException( Integer.toString( pos ) );
        }

        Node<E> toBeRemoved;

        if ( pos == 0 ) {
            return removeFirst();
        } else if (pos == size-1) {
            return removeLast();
        }
        else {
            Node<E> p = head;

            for ( int i=0; i<( pos-1); i++ ) {
                p = p.next;
            }
            toBeRemoved = p.next;
            p.next = p.next.next;
        }
        size--;
        return toBeRemoved.value;
    }


      /**
    * Checks if 2 lists are equal
    * @param otherList the list to be compared to the instance
    * @return true if the lists are equal, false otherwise.
    */
    public boolean equals(SinglyLinkedList<E> otherList){

        if((otherList == null) || (size != otherList.size()))
        return false;

        Node<E> thisCursor = head;
        Node<E> otherCursor = otherList.head;

        for(int i = 0; i < size; i++){
            if(!thisCursor.value.equals(otherCursor.value))
            return false;
            thisCursor = thisCursor.next;
            otherCursor = otherCursor.next;
        }

        return true;
    }



    /**
    * Returns a string representation of the list
    * @return returns the string representation of the list.
    */
    public String toString(){
        StringBuffer res = new StringBuffer();
        res.append("[");
        if(!isEmpty()){
            Node<E> cursor = head;
            res.append(cursor.value);
            while(cursor.next != null){
                cursor = cursor.next;
                res.append(" " + cursor.value);
            }
        }
        res.append("]");
        return res.toString();
    }
}