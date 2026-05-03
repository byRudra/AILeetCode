class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        mat = rotateMatrix(mat);
        if(checkMat(mat, target) == true) return true;
        mat = rotateMatrix(mat);
        if(checkMat(mat, target) == true) return true;
        mat = rotateMatrix(mat);
        if(checkMat(mat, target) == true) return true;
        mat = rotateMatrix(mat);
        if(checkMat(mat, target) == true) return true;
        return false;
        
    }
    private boolean checkMat(int[][] mat, int[][] target){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++){
                if(mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
    private int[][] rotateMatrix(int[][] mat){
        // Take transpose
        for(int i = 0; i < mat.length; i++){
            for(int j = i; j < mat.length; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for(int row = 0; row < mat.length; row++){
            for(int column = 0; column < mat.length/2; column++){
                int temp = mat[row][mat.length - (column + 1)];
                mat[row][mat.length - (column + 1)] = mat[row][column];
                mat[row][column] = temp;
            }
        } 
        return mat;
    }
}