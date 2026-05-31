# 396. Rotate Function

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/rotate-function/)

`Array` · `Math` · `Dynamic Programming`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Math, Dynamic Programming.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int maxRotateFunction(int[] nums) {
         int n = nums.length;

        long sum = 0;
        long f = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }

        long max = f;
        for (int i = 1; i < n; i++) {
            f = f - (long) n * nums[n - i] + sum;
            max = Math.max(max, f);
        }
        return  (int) max;
    }
}
```

---

**Runtime** 4 ms · **Memory** 90.6 MB

<sub>Synced by AILeetHub on 2026-05-31.</sub>
