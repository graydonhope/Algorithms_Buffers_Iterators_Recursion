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
* The main class used to test quesiton 4
*/
public class Q4 {
    /**
    * The main method
    * @param args the string arguments passed in
    */

    public static void main(String[] args) {
        StudentInfo.display();

        BinarySearchTree<Integer> bTree;
        bTree = new BinarySearchTree<Integer>();

        bTree.add(4);
        bTree.add(2);
        bTree.add(3);
        bTree.add(1);
        bTree.add(5);
        bTree.add(6);
        bTree.add(8);
        bTree.add(9);
        bTree.add(7);

        System.out.println(bTree.count(3,6));

    }
}