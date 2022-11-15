import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Task5 {
    public static void enterTask5() {
        Task5 twoDMaxSumDPn4 = new Task5();
        Scanner sizeScanner = new Scanner(System.in);  // Create a Scanner object
     //   System.out.println("Enter size of input Array");
        int rows = sizeScanner.nextInt();
        int columns = sizeScanner.nextInt();
        Scanner matrixScanner = new Scanner(System.in);
        int[][] inputMatrix = new int[rows][columns];
        for(int row=0;row<rows;++row){
            for(int col=0;col<columns;++col){
                inputMatrix[row][col] = matrixScanner.nextInt();
            }
        }
        twoDMaxSumDPn4.maxContDPn4Matrix(inputMatrix, rows, columns);
    }

    // Implementation using Inclusion-Exclusion Principle.
    public static void maxContDPn4Matrix(int[][] inputMatrix, int rows, int columns){
        long start = System.nanoTime();
        int[][] tempArrayToStoreSum = new int[rows+1][columns+1];
        for(int row=1; row<rows+1; row++) {
            for(int col=1; col<columns+1; col++) {
                // Considering the elements in the previous columns
                if(row > 0){
                    tempArrayToStoreSum[row][col] = inputMatrix[row-1][col-1] + tempArrayToStoreSum[row-1][col];
                }
                // Considering the elements in the previous row
                if(col > 0){
                    tempArrayToStoreSum[row][col] = tempArrayToStoreSum[row][col] + tempArrayToStoreSum[row][col-1];
                }
                // Removing the elements which are added twice along the diagonal.
                if(row > 0 && col > 0){
                    tempArrayToStoreSum[row][col] = tempArrayToStoreSum[row][col] - tempArrayToStoreSum[row-1][col-1];
                }

            }
        }

        int globalMaxDPn4 = Integer.MIN_VALUE;
        int startRowIndex=0, startColIndex=0, endRowIndex=0, endColumnIndex=0;

        // Iterating over all the possibilites to frame the rectangular elements.
        for(int rowLoop=1; rowLoop<rows+1; rowLoop++) {
            for (int columnLoop = 1; columnLoop < columns+1; columnLoop++) {
                for (int rLoop = rowLoop; rLoop < rows+1; rLoop++) {
                    for (int cLoop = columnLoop; cLoop < columns+1; cLoop++) {
                        int subProblemSum = tempArrayToStoreSum[rLoop][cLoop];

                        if (rowLoop > 0)
                            subProblemSum -= tempArrayToStoreSum[rowLoop - 1][cLoop];
                        if (columnLoop > 0)
                            subProblemSum -= tempArrayToStoreSum[rLoop][columnLoop - 1];
                        if (rowLoop > 0 && columnLoop > 0)
                            subProblemSum += tempArrayToStoreSum[rowLoop - 1][columnLoop - 1];

                        if (subProblemSum > globalMaxDPn4) {
                            startRowIndex = rowLoop; startColIndex = columnLoop; endRowIndex = rLoop;
                            endColumnIndex = cLoop; globalMaxDPn4 = subProblemSum;
                        }
                    }
                }
            }
        }
        System.out.println((startRowIndex)+" "+(startColIndex)+" "+(endRowIndex)+" "+(endColumnIndex)+" "+globalMaxDPn4);
        long end = System.nanoTime();
        NumberFormat formatter = new DecimalFormat("#0.0000000000");
 //       System.out.print("Execution time is " + formatter.format((float)(end - start)/(1000000000)));
    }
}