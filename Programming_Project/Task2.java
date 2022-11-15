import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Task2 {
    public static void enterTask2() {
        Task2 maxContDPQuadratic = new Task2();
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
            int intMaxBound = 32768, intMinBound = -32768, integerRange = intMaxBound - intMinBound + 1;//Max and Min range for Input Integer Values
            //Read User Input
            for (int loop = 0; loop < arraySize; loop++) {
                int inputNumber = inputArrayObj.nextInt(); // For User Input
                //int inputNumber = (int) ((Math.random() * integerRange) + intMinBound); //For Random Input Generator
                userInput[loop] = inputNumber;
            }
            //Function Call DP Quadratic Max Sum Contiguous SubArray
            maxContDPQuadratic.maxContiguousDPQuadratic(userInput);
            }
        }
        catch (NegativeArraySizeException e){
            System.out.println("Array Size Cannot be negative! Please enter valid size");
        }
    }

    //Function call to find the Max Sum Contiguos SubArray in Quadratic DP
    public static void maxContiguousDPQuadratic(int[] inputNumSet) {
            long start =  System.nanoTime();
            int n = inputNumSet.length;
            int[] maxSumQuadArraySum = new int[3]; //Array to store final subArray indices and max Sum value
            maxSumQuadArraySum[2]=Integer.MIN_VALUE; //Assigning Minimum value to global maximum sum
//            int maximumSubArraySum = Integer.MIN_VALUE;
            for (int startIndex = 0; startIndex < n; startIndex++) {
                int dynamicLocalSum = 0;
                for (int endIndex = startIndex; endIndex < n; endIndex++) {
                    //Discarded third loop and optimized the possibility scan
                    dynamicLocalSum += inputNumSet[endIndex];
                    //Updating Global Sum when new sum is greater than global. Also storing the start and end indices
                    if(maxSumQuadArraySum[2]<dynamicLocalSum) {
                        maxSumQuadArraySum[2] = dynamicLocalSum;
                        maxSumQuadArraySum[0]=startIndex+1;
                        maxSumQuadArraySum[1]=endIndex+1;
                    }
                }
            }
            System.out.println(maxSumQuadArraySum[0]+" "+ maxSumQuadArraySum[1]+" "+maxSumQuadArraySum[2]);
            long end = System.nanoTime();
            NumberFormat formatter = new DecimalFormat("#0.000000000");
//            System.out.println(start);
//            System.out.println(end);
//            System.out.print("Execution time is " + formatter.format((float)(end - start)/(1000000000)));
    }
}