import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Task1 {
    //Function to Find the maximum sum Contiguous Sub Array in Brute Force
    public void intMaxBoundSumContiguousSubArray(int[] inputNumSet){
        long start = System.nanoTime();
        int n = inputNumSet.length;
        int[] intMaxBoundPointerValues = new int[3]; //Array to store final subArray indices and max Sum value
        intMaxBoundPointerValues[2]=Integer.MIN_VALUE;//Assigning Minimum value to global maximum sum

        for (int startIndex = 0; startIndex < n; startIndex++) {
            for (int endIndex = startIndex; endIndex < n; endIndex++) {
                int localSum = 0;
                for (int k = startIndex; k <= endIndex; k++) {
                    //Looping through all possibilities
                    localSum += inputNumSet[k];
                }
                //Updating Global Sum when new sum is greater than global. Also storing the start and end indices
                if(intMaxBoundPointerValues[2]<localSum) {
                    intMaxBoundPointerValues[2] = localSum;
                    intMaxBoundPointerValues[0]=startIndex+1;
                    intMaxBoundPointerValues[1]=endIndex+1;
                }
            }
        }
        System.out.println(intMaxBoundPointerValues[0]+" "+ intMaxBoundPointerValues[1]+" "+intMaxBoundPointerValues[2]);
        long end = System.nanoTime();
        NumberFormat formatter = new DecimalFormat("#0.0000000000");
 //       System.out.print("Execution time is " + formatter.format((float)(end - start)/(1000000000)));
    }
    public static void enterTask1() {
        Task1 testintMaxBoundContiguousSum = new Task1();
        Scanner sizeScanner = new Scanner(System.in);  // Create a Scanner object
        // System.out.println("Enter size of input");
        int arraySize = sizeScanner.nextInt();
        int intMaxBound = 32768, intMinBound = -32768, integerRange = intMaxBound-intMinBound+1; //Max and Min range for Input Integer Values
        try{
            int[] userInput= new int[arraySize];
            Scanner inputArrayObj = new Scanner(System.in);  // Create a Scanner object
        if(arraySize==0) System.out.println("No Valid Input Possible for Zero");
        else if(arraySize<0) {
            throw new NegativeArraySizeException("Only Positive Numbers & no Letters Please!");
        }
        else {

            // System.out.println("Enter the integer set");
            //Read User Input
            for (int loop = 0; loop < arraySize; loop++) {
                int inputNumber = inputArrayObj.nextInt(); // For User Input Array Values
                //int inputNumber = (int)((Math.random()*integerRange)+intMinBound); //For Random Input Generator
                userInput[loop] = inputNumber;
            }
            // for (int loop = 0; loop < arraySize; loop++) {
            //     System.out.print(userInput[loop]+" ");
            // }
            // System.out.println("\n");
            
            //Function Call Brute Force Max Sum Contiguous SubArray
            testintMaxBoundContiguousSum.intMaxBoundSumContiguousSubArray(userInput);
        }}
        catch (NegativeArraySizeException e) {
            System.out.println("Array Size Cannot be negative! Please enter valid size");
        }
    }
}