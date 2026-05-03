# 1380. Lucky Numbers in a Matrix

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/lucky-numbers-in-a-matrix/)

`Array` · `Matrix`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Matrix.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int currentValue = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                currentValue = Math.min(currentValue, matrix[i][j]);
            }
            min.add(currentValue);
        }
        // column
        for (int i = 0; i < matrix[0].length; i++) {
            int currentValue = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                currentValue = Math.max(currentValue, matrix[j][i]);
            }
            max.add(currentValue);
        }
        min.retainAll(max);
        return min;
    }
}
```

---

**Runtime** 4 ms · **Memory** 46.8 MB

<sub>Synced by AILeetHub on 2026-05-03.</sub>
