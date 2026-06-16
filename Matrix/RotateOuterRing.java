/*
* this rotates only outer ring of the matrix
*
* */

public class RotateOuterRing {
    static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
        };
        rotateClockwiseByOne(matrix);
        printMatrix(matrix);
    }

    private static void rotateClockwiseByOne(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int prev = mat[1][0];
        //first row
        for(int i=0;i<col ;i++){
            int curr = mat[0][i];
            mat[0][i] = prev;
            prev = curr;
        }
        //last col
        for(int i=1;i<row;i++){
            int curr = mat[i][col-1];
            mat[i][col-1] = prev;
            prev= curr;
        }
        //last row
        for(int i= col-2;i>=0;i--){
            int curr = mat[row-1][i];
            mat[row-1][i] =prev;
            prev = curr;
        }
        //first col
        for(int i=row-2;i>=0;i--){
            int curr = mat[i][0];
            mat[i][0] =prev;
            prev = curr;
        }
    }
    private static void printMatrix(int[][] mat) {
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
