# 1886. Determine Whether Matrix Can Be Obtained By Rotation

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/)

`Array` · `Matrix`

## Intuition  
A matrix can match the target only if it is identical to the target or to one of its 90‑degree rotations. Since the matrix size is at most 10×10, we can simply generate each rotation and compare it directly.

## Approach  
The solution repeatedly rotates the matrix clockwise by 90 degrees and checks for equality with the target.  
1. **Rotation** – The `rotateMatrix` method performs an in‑place 90‑degree clockwise rotation by first transposing the matrix and then reversing each row.  
2. **Comparison** – After each rotation, `checkMat` iterates over all elements to verify that the current matrix equals the target.  
3. **Iteration** – The process is repeated four times (0°, 90°, 180°, 270°). If any rotation matches, the method returns `true`; otherwise it returns `false` after the fourth rotation.

## Complexity  
- **Time:** O(n²) – Each rotation and comparison scans the n×n matrix, and we perform at most four rotations.  
- **Space:** O(1) – All operations are done in place; only a few integer variables are used.

## Solution (java)

```java
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
```

---

**Runtime** 0 ms · **Memory** 43.8 MB

<sub>Synced by AILeetHub on 2026-05-03.</sub>
