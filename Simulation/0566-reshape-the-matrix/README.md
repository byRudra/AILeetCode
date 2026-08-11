# 566. Reshape the Matrix

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/reshape-the-matrix/)

`Array` · `Matrix` · `Simulation`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Matrix, Simulation.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length)
            return mat;
        int result[][] = new int[r][c];
        int x = 0, y = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                result[x][y] = mat[i][j];
                if (y < c - 1) {
                    y++;
                } else {
                    x++;
                    y = 0;
                }
            }
        }
        return result;
    }
}
```

---

**Runtime** 1 ms · **Memory** 47.5 MB

<sub>Synced by AILeetHub on 2026-08-11.</sub>
