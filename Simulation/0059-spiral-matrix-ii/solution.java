class Solution {
    public int[][] generateMatrix(int n) {
        int result[][] = new int[n][n];

        int top = 0, left = 0, right = n - 1, bottom = n - 1;
        int currentValue = 1;
        while(top <= bottom && left <= right){
            //top
            for(int i = top; i <= right; i++){
                result[top][i] = currentValue++;
            }
            top++;
            for(int j = top; j <= bottom; j++){
                result[j][right] = currentValue++;
            }
            right--;
            if(top <= bottom){
                for(int k = right; k >= left; k--){
                    result[bottom][k] = currentValue++;
                }
                bottom--;
            }
            if(left <= right){
                for(int l = bottom; l >= top; l--){
                    result[l][left] = currentValue++;
                }
                left++;
            }
        }
        return result;
    }
}