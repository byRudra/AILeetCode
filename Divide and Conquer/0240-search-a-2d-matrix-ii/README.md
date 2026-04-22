# 240. Search a 2D Matrix II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/search-a-2d-matrix-ii/)

`Array` · `Binary Search` · `Divide and Conquer` · `Matrix`

## Intuition
The matrix is sorted both row‑wise and column‑wise. This structure allows us to discard a whole row or column with a single comparison. Starting from the top‑right corner, any element to the left is smaller and any element below is larger. Thus, by comparing the current element with the target we can decide which direction to move to eliminate impossible regions.

## Approach
1. Set `i = 0` (first row) and `j = m-1` (last column).  
2. While `i` is within the row bounds and `j` is non‑negative:  
   * If `matrix[i][j]` equals the target, return `true`.  
   * If `matrix[i][j]` is greater than the target, the target cannot be in column `j` (all values below are even larger), so decrement `j` to move left.  
   * If `matrix[i][j]` is less than the target, the target cannot be in row `i` (all values to the left are smaller), so increment `i` to move down.  
3. If the loop exits, the target is not present; return `false`.

This greedy walk eliminates one entire row or column per step, guaranteeing that the search finishes quickly.

## Complexity
- **Time:** O(m + n) – each step moves either left or down, so at most `m + n` comparisons are made.  
- **Space:** O(1) – only a few integer variables are used, regardless of matrix size.

## Solution (java)

```java
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         for(int i = 0; i < matrix.length; i++){
//             if(matrix[i][0] <= target && target <= matrix[i][m-1]){
//                 for(int j = 0; j < m; j++){
//                     if(matrix[i][j] == target) return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

// OPTMIZED VERSION
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
```

---

**Runtime** 3 ms · **Memory** 48.1 MB

<sub>Synced by AILeetHub on 2026-04-22.</sub>
