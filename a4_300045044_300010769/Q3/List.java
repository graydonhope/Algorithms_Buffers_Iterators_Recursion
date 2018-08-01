/*	Student information:
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
public interface List<E> {
	/**
	* Adds the given object at the given index
	* @param index is the index where the item will be added
	* @param elem is the element that will be added to the list
	*/
    public abstract void add( int index, E elem );

    /**
	*Adds the given object to the end of the list
	*@param elem is the element that will be added to the list
	*/
    public abstract void add( E elem );

    /**
	* Removes the object at the given index
	*@param index is the position at which the object will be removed 
	*@return returns the object that was removed
	*/

    public abstract E remove( int index );

    /**
	* Removes the specified object from the list
	* @param o is the object that should be removed
	* @return true if the object was removed, false otherwise
	*/
    public abstract boolean remove( E o );

    /**
	* Gets the object a the given index
	* @param index is the position where the object will be returned from
	* @return returns the object at the given index
	*/
    public abstract E get( int index );


	/**
	* Determines whether the list is empty or not.
	* @return true if the list is empty and false if the list is not empty
	*/
    public abstract int size();

    /**
	* Determines whether the list is empty or not.
	* @return true if the list is empty and false if the list is not empty
	*/
    public abstract boolean isEmpty();
}