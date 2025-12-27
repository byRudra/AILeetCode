// Linear Search O(n+m)
// 100 % beat
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//             return false;
//         }
//         int rows = matrix.length;
//         int cols = matrix[0].length;

//         if (cols == 1) {
//             for (int i = 0; i < rows; i++) {
//                 if (matrix[i][0] == target) return true;
//             }
//             return false;
//         }
//         int currRow = 0;

//         for(int i = 0; i < rows; i++){
//             if(matrix[i][0] <= target && matrix[i][cols - 1] >= target){
//                 currRow = i;
//                 break;
//             }
//         } 

//         for(int num : matrix[currRow]){
//             if(target == num){return true;}
//         }
//         return false;
//     }
// }

// Linear + Binary O(m + log n)
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//             return false;
//         }
//         int rows = matrix.length;
//         int cols = matrix[0].length;

//         int currRow = -1;

//         for(int i = 0; i < rows; i++){
//             if(matrix[i][0] <= target && matrix[i][cols - 1] >= target){
//                 currRow = i;
//                 break;
//             }
//         } 
//         if (currRow == -1) return false;

//         int left = 0, right = cols -1;
//         int [] Row = matrix[currRow];
//         while(left <= right){
//             int mid = left + (right - left) / 2;
//             int midVal = Row[mid];

//             if(midVal == target) return true;
//             if(target  > midVal){
//                 left = ++mid;
//             }
//             else{
//                 right = --mid;
//             }
//         }
//         return false;
//     }
// }


// Purely Binary Search Log(n + m)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int leftIndex = 0;
        int rightIndex = rows * cols - 1;

        while(leftIndex <= rightIndex){
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

            int currentRow = midIndex / cols;
            int currentColumn = midIndex % cols;

            int middleValue = matrix[currentRow][currentColumn];

            if(middleValue == target) return true;
            else if(middleValue > target) {
                rightIndex = midIndex - 1;
            }
            else{
                leftIndex = midIndex + 1;
            }
        }
        return false;
    }
}