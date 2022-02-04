package com.mykhailo;

import java.util.Arrays;

public class Matrix {

    public static final int[][] MATRIX = {
            {10, 11, 12, 13},
            {14, 15, 16, 17},
            {18, 19, 20, 21}
    };

    public static void main(String[] args) {

        print(MATRIX);
        System.out.println();
        print(swapColumns(MATRIX, 1, 2));
        System.out.println();
        print(swapRows(MATRIX, 1, 2));
        System.out.println();
        print(multiply(MATRIX, 2));
        System.out.println();
        System.out.println(Arrays.toString(toArray(MATRIX)));
        System.out.println();
        System.out.println(maxValue(MATRIX));

    }

    /*
     * Method for printing out a 2D array in matrix format
     */
    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
     * Method for swapping columns in a 2D array
     */
    public static int[][] swapColumns(int[][] matrix, int firstColumn, int secondColumn) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][firstColumn - 1];
            matrix[i][firstColumn - 1] = matrix[i][secondColumn - 1];
            matrix[i][secondColumn - 1] = temp;
        }
        return matrix;
    }

    /*
     * Method for swapping rows in a 2D array
     */
    public static int[][] swapRows(int[][] matrix, int firstRow, int secondRow) {
        int[] tempRow = matrix[firstRow - 1];
        matrix[firstRow - 1] = matrix[secondRow - 1];
        matrix[secondRow - 1] = tempRow;
        return matrix;
    }

    /*
     * Method to multiply each element of a 2D array
     */
    public static int[][] multiply(int[][] matrix, int value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= value;
            }
        }
        return matrix;
    }

    /*
     *  Method for converting matrix to an array
     */
    public static int[] toArray(int[][] matrix) {
        int[] array = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                array[i * matrix[i].length + j] = matrix[i][j];
            }
        }
        return array;
    }

    /*
     *  Method to find minimum value of a matrix
     */
    public static int maxValue(int[][] matrix) {
        int maxValue = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxValue < matrix[i][j]) {
                    maxValue = matrix[i][j];
                }
            }
        }
        return maxValue;
    }
}