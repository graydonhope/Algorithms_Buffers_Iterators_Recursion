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
* The class used to test question 3
*/
public class Q3 {
    /**
    * Prints the distance between two strings inside of a list (inclusive)
    * @param first is beginning of the distance
    * @param second is the last element to measure the distance between
    * @param l is the list to be searched
    */

    private static void testCount(String first, String second, SinglyLinkedList<String> l){
        System.out.println("Distance between " + first
        + " and " + second +" is " + l.count(first,second));
    }
    /**
    * Main method 
    * @param args the string of arguments passed in
    */
    public static void main(String[] args) {

        StudentInfo.display();

        SinglyLinkedList<String> l;
        l = new SinglyLinkedList<String>();

        l.add("A");
        l.add("B");
        l.add("C");
        l.add("D");
        l.add("A");
        l.add("B");
        l.add("C");
        l.add("D");
        l.add("E");
        System.out.println(l);
        testCount("A","A",l);
        testCount("A","B",l);
        testCount("A","D",l);
        testCount("A","E",l);
        testCount("A","F",l);
        testCount("B","B",l);
        testCount("B","A",l);
        testCount("B","D",l);
        testCount("B","E",l);
        testCount("B","F",l);
        testCount("E","A",l);
        testCount("F","A",l);
        testCount(null,"A",l);
        testCount("A",null,l);

    }
}