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
* The interface for an iterator ensuring an iterator has a next, hasNext and nextIndex
*/
public interface Iterator<E> {
	/**
	* Get the next item in the iterator
	* @return returns the next item in the iteration
	*/
    E next();

    /**
    * Determine if the iterator has a next item to iterate to
    * @return returns true if a call to next will work, false if otherwise
    */
    boolean hasNext();

    /**
    * Determine the index of the item that will be returned by the next call to the method next()
    * @return returns the index of the item that will be returned by the next call to the method next()
    */
    int nextIndex();
}