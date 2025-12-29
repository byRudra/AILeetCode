# 48. Rotate Image

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/rotate-image/)

`Array` · `Math` · `Matrix`

## Intuition
Rotating a square matrix 90° clockwise can be decomposed into two simple in‑place operations: first flip the matrix over its main diagonal (transpose), then reverse each row. The transpose swaps elements across the diagonal, turning rows into columns. Reversing each row then mirrors the transposed matrix horizontally, producing the desired clockwise rotation.

## Approach
1. **Transpose** – Iterate over the upper triangle of the matrix (`row < column`). For each pair `(row, column)`, swap `matrix[row][column]` with `matrix[column][row]`. This exchanges elements symmetrically about the main diagonal.
2. **Reverse rows** – For every row, swap elements symmetrically around the center: `matrix[row][col]` with `matrix[row][length-1-col]` for `col` from `0` to `length/2 - 1`. This mirrors each row, completing the 90° clockwise rotation.

Both passes use only a few temporary variables, so the transformation occurs entirely in the original matrix.

## Complexity
- **Time:** O(n²) – each of the two nested loops visits every element once, performing a constant amount of work per element.  
- **Space:** O(1) – only a handful of integer variables are used; no additional data structures grow with input size.

## Solution (java)

```java
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
```

---

**Runtime** 0 ms · **Memory** 44 MB

<sub>Synced by AILeetHub on 2025-12-29.</sub>
