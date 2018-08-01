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
    * The ITI version of the StringBuffer class in Java that can efficiently concatinate strings
    * and has a fast toString method.
    */
import java.util.*;

public class ITIStringBuffer{
    /**
    * The list that holds the strings added to the buffer
    */
    private SinglyLinkedList<String> stringList;

    /**
    * Constrcuts a new ITIStringBuffer Object and intalizes the instance variables
    */

    public ITIStringBuffer() {
        this.stringList = new SinglyLinkedList<String>();
    }


    /**
    *Constructs a ITIStringBuffer object containing the string entered for the parameter.
    *@param firstString the string to be added to the buffer
    */

    public ITIStringBuffer(String  firstString){
        this.stringList = new SinglyLinkedList<String>();
        this.stringList.add(firstString);
    }

    /**
    * Adds a string to the buffer
    * @param nextString is the string to be added to the buffer
    */

    public void append(String nextString){
      this.stringList.add(nextString);
    }
    /**
    * Returns a concatination of the strings in the buffer
    * @return the concatination of the strings in the buffer
    */

    public String toString(){
        Iterator<String> iterator = stringList.iterator();
        char[] arrayOfWords;
        int size = 0;
        int currentIndex = 0;

        while(iterator.hasNext()){
            size += iterator.next().length();
        }

        iterator = stringList.iterator();
        arrayOfWords = new char[size];

        while(iterator.hasNext()){
            char[] currentWord = iterator.next().toCharArray();
            for(int index = 0; index < currentWord.length; index++){
                arrayOfWords[currentIndex] = currentWord[index];
                currentIndex++;
            }
        }
        return new String(arrayOfWords);

    }

}
