// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int rows = matrix.length;
//         int columns = matrix[0].length;
        
//         boolean zeroRow[] = new boolean[rows];
//         boolean zeroColumn[] = new boolean[columns];

//         for(int i = 0; i< rows; i++){
//             for(int j = 0; j < columns; j++){
//                 if(matrix[i][j] == 0){
//                     zeroRow[i] = true;
//                     zeroColumn[j] = true;
//                 }
//             }
//         }

//         for(int row = 0; row < rows; row++){
//             for(int column = 0; column < columns; column++){
//                 if(zeroRow[row] || zeroColumn[column]){
//                     matrix[row][column] = 0;
//                 } 
//             }
//         }
//     }
// }

// the most optimal approach
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int col0 = 1, row0 = 1;

        for(int i = 0; i< rows; i++){
            for(int j = 0; j < columns; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) row0 = 0;
                    if(j == 0) col0 = 0;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int row = 1; row < rows; row++){
            for(int column = 1; column < columns; column++){
                if(matrix[row][0] == 0|| matrix[0][column] == 0){
                    matrix[row][column] = 0;
                } 
            }
        }

        if(row0 == 0){
            for(int column = 0; column < columns; column++){
                matrix[0][column] = 0;
            }
        }
        if(col0 == 0){
            for(int row = 0; row < rows; row++){
                matrix[row][0] = 0;
            }
        }
    }
}