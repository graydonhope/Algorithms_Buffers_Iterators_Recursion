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
* Q1 is a class that test runs the tests for question 1
*/
public class Q1 {
    /**
    * the size of the test, set to 10,000
    */
    private static int sizeOfTest = 10000;
    /**
    * The string that will be used to test ITIStringBuffer
    */

    private static String testString = "This is some string that I am testing with ...";

    /**
    * The result from the ITIString buffer
    */

    private static String resultBuffer = "";

    /**
    * The result from the typical concatination 
    */
    private static String resultConcat = "";

    /**
    * The ITIStringBuffer used to test the buffer
    */
    private static ITIStringBuffer buffer = new ITIStringBuffer();

   /**
   * The method used to test the ITIStringBuffer 
   */
    private static void testStringBuffer() {

        long start = System.currentTimeMillis();
        for(int i = 0; i < sizeOfTest; i++){
            buffer.append(testString + i );
        }
        long inter = System.currentTimeMillis();
        resultBuffer = buffer.toString();
        long end = System.currentTimeMillis();

        System.out.print("It took " + (end-start) + " ms with ITI1121StringBuffer ("
        + (inter-start) + " to append and "
        + (end - inter) + " to generate).");

        inter = System.currentTimeMillis();
        resultBuffer = buffer.toString();
        end = System.currentTimeMillis();
        System.out.println(" Regenerating the string took " + (end-inter) + " ms.");
    }

    /**
    * The method used to test the regular concatination in java
    */

    private static void testStringAppend(){

        long start = System.currentTimeMillis();
        for(int i = 0; i < sizeOfTest; i++){
            resultConcat += testString + i;
        }
        long end = System.currentTimeMillis();

        System.out.println("It took " + (end-start) + " ms directly with String.");
    }

    /**
    * The method that will run the test between ITIStringBuffer and the typical concatinaion of the strings
    */

    private static void oneRound() {

        testStringBuffer();
        testStringAppend();
        if(!resultBuffer.equals(resultConcat)) {
            System.out.println("Error, the strings are not the same");
            return;
        } else{
            System.out.println("OK, the strings are the same.");
        }

    }
    /**
    * The main method to run the OneRound method 3 times.
    * @param args the string of arguments passed into the main method
    */
    
    public static void main(String[] args) {

        /*
        ITIStringBuffer marco = new ITIStringBuffer();
        marco.append("Marco");
        marco.append(" Polo");
        System.out.println(marco);
        marco.append(" walks into a bar...");
        System.out.println(marco.toString());
        */
        StudentInfo.display();

        System.out.println("First round");
        oneRound();

        System.out.println("Second round");
        oneRound();

        System.out.println("Third round");
        oneRound();
    }
}