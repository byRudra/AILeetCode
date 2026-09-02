# 4038. Count Integers Appearing in a Single Block

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/count-integers-appearing-in-a-single-block/)

## Approach

Accepted easy solution in java.
Relevant topics: n/a.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int countSpecialIntegers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> bad = new HashSet<>();
        int prev = -1;

        for(int num : nums){
            if(num != prev && seen.contains(num))
                bad.add(num);
            seen.add(num);
            prev = num;
        }
        return seen.size() - bad.size();
    }   
}
```

---

**Runtime** 1 ms · **Memory** 43.7 MB

<sub>Synced by AILeetHub on 2026-09-02.</sub>
