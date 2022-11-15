import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Task3A {
    public static int globalMax = 0;
    public static int startIndex = 0;
    public static int endIndex = 0;
    public static int localStartIndex = 0;
    public static int threadLevel = 0;
    public static void enterTask3a(){
        Task3A maxContigousMemoized = new Task3A();
        Scanner sizeScanner = new Scanner(System.in);  // Create a Scanner object
        // System.out.println("Enter size of input");
        int arraySize = sizeScanner.nextInt();
        try {
            int[] userInput = new int[arraySize];
            Scanner inputArrayObj = new Scanner(System.in);  // Create a Scanner object
            if(arraySize==0) System.out.println("No Valid Input Possible for Zero");
            else if(arraySize<0) {
                throw new NegativeArraySizeException("Only Positive Numbers & no Letters Please!");
            }
            else{
            // System.out.println("Enter the integer set");
            int intMaxBound = 30, intMinBound = -30, integerRange = intMaxBound - intMinBound + 1;//Max and Min range for Input Integer Values
            //Read User Input
            for (int loop = 0; loop < arraySize; loop++) {
                int inputNumber = inputArrayObj.nextInt(); // For User Input
//                int inputNumber = (int) ((Math.random() * integerRange) + intMinBound); //For Random Input Generator
                userInput[loop] = inputNumber;
            }
                long start = System.nanoTime();
                globalMax = userInput[0];
                //Function Call DP Linear Max Sum Contiguous SubArray - Memoization Algorithm
                maxContigousMemoized.maxContSumMemoized(userInput, arraySize);
                System.out.println((startIndex + 1) + " " + (endIndex + 1) + " " + globalMax);
                long end = System.nanoTime();
                NumberFormat formatter = new DecimalFormat("#0.000000000");
//                System.out.println(start);
//                System.out.println(end);
//                System.out.print("Execution time is " + formatter.format((float)(end - start)/(1000000000)));
            }
        }
        catch (NegativeArraySizeException e){
            System.out.println("Array Size Cannot be negative! Please enter valid size");
        }catch (StackOverflowError e){
            System.err.println("true recursion level was " + threadLevel);
            System.err.println("reported recursion level was "
                    + e.getStackTrace().length);
        }
    }

    //Algorithm to find the max sum Contiguous SubArray in Linear Time using Top-Down Approach- Memoization Algorithm
    public static int maxContSumMemoized(int[] inputNumSet, int arrSize) {
        threadLevel++;
        //BaseCase Solution
        if(arrSize==1){
            return inputNumSet[0];
        }
        int localMax = maxContSumMemoized(inputNumSet,arrSize-1);
        if(localMax<0){
            localMax = inputNumSet[arrSize-1]; //Recursive Call - Top-Down
            localStartIndex = arrSize-1;
        } else{
            localMax += inputNumSet[arrSize-1];
        }
        //Comparing the recursive solution to the globalMax and updating if its greater
        if(globalMax < localMax){
            globalMax = localMax; startIndex = localStartIndex; endIndex = arrSize-1;
        }
//        else if((globalMax==localMax)&&((endIndex-startIndex)<((arrSize-1)-localStartIndex))){
//            startIndex = localStartIndex;
//            endIndex = arrSize-1;
//        }
        return localMax;
    }
}