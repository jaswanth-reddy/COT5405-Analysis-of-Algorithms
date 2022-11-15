import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Task6 {
    public static void enterTask6() {
        Task6 twoDMaxSumDPn3 = new Task6();
        Scanner sizeScanner = new Scanner(System.in);  // Create a Scanner object
     //   System.out.println("Enter size of input Array");
        int rows = sizeScanner.nextInt();//Number of Rows in input Matrix
        int columns = sizeScanner.nextInt();//Number of Columns in input Matrix
        Scanner matrixScanner = new Scanner(System.in);
        int[][] inputMatrix = new int[rows][columns];
        //Read User input Matrix
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < columns; ++col) {
                inputMatrix[row][col] = matrixScanner.nextInt();
            }
        }
        //Function call to find the sub rectangle in n^3
        twoDMaxSumDPn3.maxContDPn6Matrix(inputMatrix, rows, columns);
    }

    //Function to find the Max Sum Rectangle from the User provided two Dimensional Matrix in n^3 complex Approach
    public static void maxContDPn6Matrix(int[][] inputMatrix, int rows, int columns) {
        long start = System.nanoTime();
        int negativeRowIndex = 0, negativeColIndex = 0, rowStartIndex = 0, rowEndIndex = 0, colStartIndex = 0, colEndIndex = 0;
        int globalMinDPn3 = Integer.MIN_VALUE;
        int globalMaxDPn3 = -1;
        int initAdd[][] = new int[rows + 1][columns];
        for (int rowLoop = 0; rowLoop < rows; rowLoop++) {
            for (int colLoop = 0; colLoop < columns; colLoop++) {
                initAdd[rowLoop + 1][colLoop] = initAdd[rowLoop][colLoop] + inputMatrix[rowLoop][colLoop];
            }
        }
        for (int rowStart = 0; rowStart < rows; rowStart++) { for (int row = rowStart; row < rows; row++) {
                int localSum = 0, localColumnStart = 0;
                for (int col = 0; col < columns; col++) {
                    localSum += initAdd[row + 1][col] - initAdd[rowStart][col];
                    if (localSum < 0) {
                        if (globalMinDPn3 < localSum) {
                            globalMinDPn3 = localSum; negativeRowIndex = row; negativeColIndex = col;
                        }
                        localSum = 0; localColumnStart = col + 1;
                    } else if (globalMaxDPn3 < localSum) {
                        globalMaxDPn3 = localSum; rowStartIndex = rowStart; rowEndIndex = row;
                        colStartIndex = localColumnStart; colEndIndex = col;
                    }
                }
            }
        }
        if (globalMaxDPn3 == -1) {
            globalMaxDPn3 = globalMinDPn3; rowStartIndex = rowEndIndex = negativeRowIndex; colStartIndex = colEndIndex = negativeColIndex;
        }
        System.out.println((rowStartIndex + 1) + " " + (colStartIndex + 1) + " " + (rowEndIndex + 1) + " " + (colEndIndex + 1) + " " + globalMaxDPn3);
        long end = System.nanoTime();
        NumberFormat formatter = new DecimalFormat("#0.0000000000");
  //      System.out.print("Execution time is " + formatter.format((float)(end - start)/(1000000000)));
    }
}