import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Task4 {
    public static void enterTask4() {
        Task4 twoDMaxSumBF = new Task4();
        Scanner sizeScanner = new Scanner(System.in);  // Create a Scanner object
   //     System.out.println("Enter size of input Array");
        int rows = sizeScanner.nextInt(); //Number of Rows in input Matrix
        int columns = sizeScanner.nextInt(); //Number of Columns in input Matrix
        Scanner matrixScanner = new Scanner(System.in);
        int[][] inputMatrix = new int[rows][columns];
        int intMaxBound = 30, intMinBound = -30, integerRange = intMaxBound - intMinBound + 1;//Max and Min range for Input Integer Values
        //Read User input Matrix
        for(int row=0;row<rows;++row){
            for(int col=0;col<columns;++col){
                inputMatrix[row][col] = matrixScanner.nextInt();
              //  inputMatrix[row][col] = (int) ((Math.random() * integerRange) + intMinBound); // For Randomly Generated Input
            }
        }
    //    for(int row=0;row<rows;++row){
    //         for(int col=0;col<columns;++col){
    //            System.out.print(inputMatrix[row][col]+" ");
    //         }
    //     }
    //     System.out.println("\n");
        //Function call to find the sub rectangle in n^6 Brute Force
        twoDMaxSumBF.maxContBFMatrix(inputMatrix, rows, columns);
    }
    //Function to find the Max Sum Rectangle from the User provided two Dimensional Matrix in n^6 Brute Force Approach
    public static void maxContBFMatrix(int[][] inputMatrix, int rows, int columns) {
        long start = System.nanoTime();
        int maxBFMatSum = Integer.MIN_VALUE, leftIndex = 0, rightIndex = 0, topIndex = 0, endIndex = 0;
        //Brute Force - Looping through each possibility of a submatrix
        for (int startLeft = 0; startLeft < rows; ++startLeft) { for (int startTop = 0; startTop < columns; ++startTop) {
                for (int endLeft = startLeft; endLeft < rows; ++endLeft) { for (int endTop = startTop; endTop < columns; ++endTop) {
                        int localSum = 0;
                        for (int rowLoop = startLeft; rowLoop <= endLeft; ++rowLoop) {
                            for (int colLoop = startTop; colLoop <= endTop; ++colLoop) {
                                //updating the possible localSum, which would be compared later
                                localSum += inputMatrix[rowLoop][colLoop];
                            }
                        }
                        //Comparing the localSum from the brute force approach with the existing global Maximum.
                        // Updating global max if a greater sum solution is obtained
                        if (localSum > maxBFMatSum) {
                                maxBFMatSum = localSum; leftIndex = startTop + 1;
                                rightIndex = endTop + 1; topIndex = startLeft + 1; endIndex = endLeft + 1;
                        }
                    }
                }
            }
        }
        System.out.println(topIndex + " " + leftIndex + " " + endIndex + " " + rightIndex + " " + maxBFMatSum);
        long end = System.nanoTime();
        NumberFormat formatter = new DecimalFormat("#0.0000000000");
   //     System.out.print("Execution time is " + formatter.format((float)(end - start)/(1000000000)));
    }
}