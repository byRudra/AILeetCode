# 74. Search a 2D Matrix

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/search-a-2d-matrix/)

`Array` · `Binary Search` · `Matrix`

## Intuition
We treat the matrix as a single sorted list because every row is sorted and the first element of a row is larger than the last element of the previous row. This guarantees that if we read the matrix row‑by‑row we see a strictly increasing sequence, so a binary search can be applied directly.

## Approach
The algorithm keeps two indices, `leftIndex` and `rightIndex`, that bound the current search interval in the virtual 1‑D view of the matrix. In each loop iteration we compute `midIndex` as the middle of the interval, then translate it to a row and column with integer division and modulo. The value at `matrix[row][col]` is compared to the target. If it matches we return true; if it is larger we move the right bound left, otherwise we move the left bound right. When the bounds cross the target is absent and we return false.

## Complexity
- **Time:** O(log(m*n)) – each iteration halves search space.  
- **Space:** O(1) – only a few integer variables.

## Solution (java)

```java
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
```

---

**Runtime** 0 ms · **Memory** 44.1 MB

<sub>Synced by AILeetHub on 2025-12-27.</sub>
