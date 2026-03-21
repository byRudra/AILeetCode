# 3070. Count Submatrices with Top-Left Element and Sum Less Than k

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/)

`Array` · `Matrix` · `Prefix Sum`

## Intuition
Every submatrix that contains the top‑left element of the grid is uniquely identified by its bottom‑right corner.  
If we know the sum of the rectangle from `(0,0)` to any cell `(i,j)`, we immediately know whether that submatrix satisfies the bound `k`.  
Thus the problem reduces to computing these cumulative sums efficiently.

## Approach
The algorithm builds a 2‑D prefix sum in place.  
For each cell `(i,j)` it updates `grid[i][j]` to be the sum of all elements in the rectangle from `(0,0)` to `(i,j)` using the recurrence

```
grid[i][j] += grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1]
```

(adding the cell itself is already present).  
After the update, if the new value is ≤ `k`, the submatrix ending at `(i,j)` is counted.  
Iterating over all cells yields the total number of qualifying submatrices.

## Complexity
- **Time:** O(m × n) – each cell is processed once.  
- **Space:** O(1) – the prefix sums are stored in the original matrix, no extra arrays are used.

## Solution (java)

```java
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        // Build prefix sum in-place
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i > 0) grid[i][j] += grid[i - 1][j];
                if (j > 0) grid[i][j] += grid[i][j - 1];
                if (i > 0 && j > 0) grid[i][j] -= grid[i - 1][j - 1];

                if (grid[i][j] <= k) {
                    count++;
                }
            }
        }

        return count;
    }
}
```

---

**Runtime** 7 ms · **Memory** 161.5 MB

<sub>Synced by AILeetHub on 2026-03-21.</sub>
