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
* The class used to question Q2
*/
public class Q2 {

    /**
    * The main method used to tes question 2
    * @param args the arguments passed into the main
    */ 

    public static void main(String[] args) {

        StudentInfo.display();

        LinkedList<String> alphabet;
        alphabet = new LinkedList<String>();

        alphabet.add("alpha");
        alphabet.add("bravo");
        alphabet.add("charlie");
        alphabet.add("delta");
        alphabet.add("echo");

        Iterator<String> i;
        i = alphabet.iterator();

        while (i.hasNext()) {
            System.out.println(i.nextIndex());
            System.out.println(i.next());
        }
        System.out.println(i.nextIndex());
    }
}