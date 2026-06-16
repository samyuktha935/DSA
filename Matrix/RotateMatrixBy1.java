/*
Roatate matrix by 1
Only complete rings (layers) are rotated.
Example of a ring:
      1 2 3
      8   4
      7 6 5

A 2x2 matrix is also a valid ring:
    1 2
    3 4
 these are not considered as rings single row , col,element  in middle or anywhere

*/

public class RotateMatrixBy1 {
    static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotateClockwiseByOne(matrix);
        printMatrix(matrix);
    }
    private static void rotateClockwiseByOne(int[][] mat) {
        int top = 0;
        int left = 0;
        int bottom = mat.length - 1;
        int right = mat[0].length - 1;

        while (top < bottom && left < right) {

            int prev = mat[top + 1][left];

            // Top row
            for (int j = left; j <= right; j++) {
                int curr = mat[top][j];
                mat[top][j] = prev;
                prev = curr;
            }
            top++;

            // Right column
            for (int i = top; i <= bottom; i++) {
                int curr = mat[i][right];
                mat[i][right] = prev;
                prev = curr;
            }
            right--;

            // Bottom row
            for (int j = right; j >= left; j--) {
                int curr = mat[bottom][j];
                mat[bottom][j] = prev;
                prev = curr;
            }
            bottom--;

            // Left column
            for (int i = bottom; i >= top; i--) {
                int curr = mat[i][left];
                mat[i][left] = prev;
                prev = curr;
            }
            left++;
        }
    }
    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
