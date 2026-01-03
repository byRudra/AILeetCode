# 2965. Find Missing and Repeated Values

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-missing-and-repeated-values/)

`Array` · `Hash Table` · `Math` · `Matrix`

## Intuition
The matrix contains every number from 1 to N = n² exactly once, except that one value a appears twice and another value b is missing.  
If we compare the actual sums of all entries with the sums that a perfect 1…N sequence should have, the differences reveal the two unknowns.  
Using both the sum and the sum of squares gives two independent equations that can be solved for a and b.

## Approach
1. Compute `N = n*n`.  
2. Calculate the expected sum `Sₑ = N(N+1)/2` and expected sum of squares `S₂ₑ = N(N+1)(2N+1)/6`.  
3. Iterate over the matrix once, accumulating `Sₐ` (actual sum) and `S₂ₐ` (actual sum of squares).  
4. `diff = Sₐ – Sₑ = a – b`.  
5. `diffSq = S₂ₐ – S₂ₑ = a² – b² = (a – b)(a + b)`.  
6. `sum = diffSq / diff = a + b`.  
7. Solve the linear system:  
   * `a = (sum + diff) / 2`  
   * `b = a – diff`.  
8. Return `[a, b]`.

## Complexity
- **Time:** O(n²) – one pass over all n² elements.  
- **Space:** O(1) – only a handful of integer/long variables are used.

## Solution (java)

```java
// O (n²)

// class Solution {
//     public int[] findMissingAndRepeatedValues(int[][] grid) {
//         int[] result = new int[2];
//         HashSet<Integer> seenNumbers = new HashSet<>();
//         int n = grid.length;
//         for (int row = 0; row < n; row++) {
//             for (int col = 0; col < n; col++) {
//                 int value = grid[row][col];
//                 if (seenNumbers.contains(value)) {
//                     result[0] = value;
//                 } else {
//                     seenNumbers.add(value);
//                 }
//             }
//         }
//         for (int index = 1; index <= n * n; index++) {
//             if (!seenNumbers.contains(index)) {
//                 result[1] = index;
//                 break;
//             }
//         }

//         return result;
//     }
// }

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = n * n;

        long expectedSum = N * (N + 1) / 2;
        long expectedSumSquared = N * (N + 1) * (2 * N + 1) / 6;

        long actualSum = 0;
        long actualSumSquared = 0;

        for (int[] row : grid) {
            for (int col : row) {
                actualSum += col;
                actualSumSquared += col * col;
            }
        }

        long diff =  actualSum - expectedSum;
        long diffSquare = actualSumSquared -  expectedSumSquared;

        long sum = diffSquare / diff;

        int repeatingNumber = (int) ((sum + diff) / 2);
        int missingNumber = (int) (repeatingNumber - diff);

        return new int[] { repeatingNumber, missingNumber };

    }
}

```

---

**Runtime** 1 ms · **Memory** 47.3 MB

<sub>Synced by AILeetHub on 2026-01-03.</sub>
