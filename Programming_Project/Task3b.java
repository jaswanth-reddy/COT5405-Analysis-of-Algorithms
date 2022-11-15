import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Task3b {
    //Algorithm to find the max sum Contiguous SubArray in Linear Time using Bottom-up Approach/ Iterative Approach
    public static void IterativeBottomUpDP(int[] inputNumSet){
        try {
            long start = System.nanoTime();
            int globalMaxSum = inputNumSet[0], globalStart = 0, globalEnd = 0;
            int localMaxSum = inputNumSet[0], localStart = 0;
            //Bottom up - iteratively checking the localMax at each index
            for (int loop = 1; loop < inputNumSet.length; loop++) {
                if (localMaxSum + inputNumSet[loop] < inputNumSet[loop]) {
                    localMaxSum = inputNumSet[loop];
                    localStart = loop;
                } else {
                    localMaxSum += inputNumSet[loop];
                }
                if (globalMaxSum < localMaxSum) {
                    globalMaxSum = localMaxSum; globalStart = localStart;
                    globalEnd = loop;
                }
//                else if (globalMaxSum == localMaxSum) {
//                    if ((globalEnd - globalStart) < (loop - localStart)) {
//                        globalStart = localStart;
//                        globalEnd = loop;
//                    }
//                }
            }

            System.out.println((globalStart+1) + " " + (globalEnd+1) + " " + globalMaxSum);
            long end = System.nanoTime();
            NumberFormat formatter = new DecimalFormat("#0.000000000");
//            System.out.println(start);
//            System.out.println(end);
//            System.out.print("Execution time is " + formatter.format((float) (end - start) / (1000000000)) + " seconds");
        }
        catch (Exception e){
            System.out.println("Exception: "+e);
        }
    }


    public static void enterTask3b() {
        Task3b maxContDPLinear = new Task3b();
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
            else {
                // System.out.println("Enter the integer set");
                int intMaxBound = 32768, intMinBound = -32768, integerRange = intMaxBound - intMinBound + 1; //Max and Min range for Input Integer Values
                //Read User Input
                for (int loop = 0; loop < arraySize; loop++) {
                    int inputNumber = inputArrayObj.nextInt(); // For User Input
                    //int inputNumber = (int) ((Math.random() * integerRange) + intMinBound); //For Random Input Generator
                    userInput[loop] = inputNumber;
                }
                //Function Call DP Linear Max Sum Contiguous SubArray - Iterative Approach
                maxContDPLinear.IterativeBottomUpDP(userInput);
            }
        }
        catch (NegativeArraySizeException e){
            System.out.println("Array Size Cannot be negative! Please enter valid size");
        }
    }

}