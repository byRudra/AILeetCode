class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //Take Transpose
        for(int row = 0; row < length; row++){
            for(int column = row + 1; column < length; column++){
                int temp = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = temp;
            }
        } 
        //Reverse the matrix

        for(int row = 0; row < length; row++){
            for(int column = 0; column < length/2; column++){
                int temp = matrix[row][length - (column + 1)];
                matrix[row][length - (column + 1)] = matrix[row][column];
                matrix[row][column] = temp;
            }
        } 

    }
}