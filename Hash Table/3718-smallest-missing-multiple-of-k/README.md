# 3718. Smallest Missing Multiple of K

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/smallest-missing-multiple-of-k/)

`Array` · `Hash Table`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Hash Table.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int multiplier = 1;
        while (true) {
            if (!set.contains(k * multiplier))
                return multiplier * k;
            multiplier++;
        }
    }
}

```

---

**Runtime** 2 ms · **Memory** 45.3 MB

<sub>Synced by AILeetHub on 2026-08-25.</sub>
