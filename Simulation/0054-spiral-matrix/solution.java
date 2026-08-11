class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, right = matrix[0].length - 1, left = 0;
        while((left <= right) && (top <= bottom)){
            for(int i = left; i <= right; i++){
                spiralList.add(matrix[top][i]);
            }
            top++;

            for(int j = top; j <= bottom; j++){
                spiralList.add(matrix[j][right]);
            }
            right--;
            if(top <= bottom){
            for(int k = right; k >= left; k--){
                spiralList.add(matrix[bottom][k]);
            }
            bottom--;
            }
            if(left <= right){
            for(int l = bottom; l >= top; l--){
                spiralList.add(matrix[l][left]);
            }
            left++;

            }
        }
        return spiralList;
    }
}