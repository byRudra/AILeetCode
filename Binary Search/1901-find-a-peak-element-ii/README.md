# 1901. Find a Peak Element II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-a-peak-element-ii/)

`Array` · `Binary Search` · `Matrix`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Binary Search, Matrix.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;

        int left = 0;
        int right = column - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // finding max element row
            int maxRow = 0;
            for (int i = 0; i < row; i++) {
                if (mat[i][mid] > mat[maxRow][mid])
                    maxRow = i;
            }

            // checking adjecent values

            int leftValue = (mid - 1 >= 0) ? mat[maxRow][mid - 1] : -1;
            int rightValue = (mid + 1 < column) ? mat[maxRow][mid + 1] : -1;

            int currentValue = mat[maxRow][mid];
            // check Peak Value

            if(leftValue < currentValue && rightValue < currentValue) return new int[]{maxRow, mid};

            // checking the greater way to go

            if(leftValue > currentValue){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
```

---

**Runtime** 0 ms · **Memory** 116.3 MB

<sub>Synced by AILeetHub on 2026-05-06.</sub>
