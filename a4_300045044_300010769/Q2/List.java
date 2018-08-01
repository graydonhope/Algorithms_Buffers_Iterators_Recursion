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
public interface List<E> {
	/**
    *Adds the given object to the front of the list
    *@param elem is the element that will be added to the front of the list
    */
    void addFirst(E elem);

    /**
	* Get the size of the list
	* @return returns the number of elements in the list
	*/
    int size();

    /**
	* Gets the object a the given index
	* @param index is the position where the object will be returned from
	* @return returns the object at the given index
	*/
    E get(int index);

     /**
    * Creates and returns an instance of a LinkedListIterator
    * @return an instance of a LinkedListIterator 
    */
    Iterator<E> iterator();

    /**
    * Creates and returns an instance of a LinkedListIterator that begins are the specified index
    * @param nextIndex the index where the iterator will begin
    * @return an instance of a LinkedListIterator 
    */
    Iterator<E> iterator(int nextIndex);

     /**
    * Creates and returns an instance of a LinkedListIterator that begins at the same position as the index given in the parameter
    * @param other the first iterator that will be used to make a new iterator that begins at the same position
    * @return an instance of a LinkedListIterator 
    */
    Iterator<E> iterator(Iterator<E> other);

}