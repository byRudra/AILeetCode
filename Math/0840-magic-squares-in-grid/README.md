# 840. Magic Squares In Grid

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/magic-squares-in-grid/)

`Array` · `Hash Table` · `Math` · `Matrix`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Hash Table, Math, Matrix.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    private boolean isMagicSquare(int[][] grid, int row, int col) {
        if (grid[row + 1][col + 1] != 5)
            return false;
        boolean[] seenNum = new boolean[10];

        // marking seen characters

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int value = grid[i][j];
                if (value < 0 || value > 9 || seenNum[value]) {
                    return false;
                }
                seenNum[value] = true;
            }
        }

        int magicSum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];

        // checking row

        for (int i = 0; i < 3; i++) {
            int rowSum = grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2];
            if (rowSum != magicSum)
                return false;
        }

        // checking column

        for (int i = 0; i < 3; i++) {
            int colSum = grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i];
            if (colSum != magicSum)
                return false;
        }

        // checking diagonals

        int firstDiagonal = grid[row][col] + grid[row + 1][col +1] + grid[row + 2][col +2];
        int secondDiagonal = grid[row][col+2] + grid[row + 1][col +1] + grid[row + 2][col];

        return (firstDiagonal == magicSum && secondDiagonal == magicSum);
    }

    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int numMagicSquares = 0;

        for (int row = 0; row <= rows - 3; row++) {
            for (int col = 0; col <= columns - 3; col++) {
                if (isMagicSquare(grid, row, col))
                    numMagicSquares++;
            }
        }
        return numMagicSquares;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.3 MB

<sub>Synced by AILeetHub on 2025-12-31.</sub>
