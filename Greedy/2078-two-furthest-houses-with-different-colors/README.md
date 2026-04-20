# 2078. Two Furthest Houses With Different Colors

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/two-furthest-houses-with-different-colors/)

`Array` · `Greedy`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Greedy.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int maxDistance(int[] colors) {
        int max = 0;
        // going forward with fixed end
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != colors[colors.length - 1]) {
                max = Math.max(max, colors.length - 1 - i);
            }
        }

        // going backward with fixed start
        for (int i = colors.length - 1; i >= 0; i--) {
            if (colors[0] != colors[i]) {
                max = Math.max(max, i - 0);
            }
        }

        return max;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.1 MB

<sub>Synced by AILeetHub on 2026-04-20.</sub>
