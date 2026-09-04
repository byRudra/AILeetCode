# 485. Max Consecutive Ones

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/max-consecutive-ones/)

`Array`

## Approach

Accepted easy solution in Java.
Relevant topics: Array.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (Java)

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int curCount = 0;
        for(int num : nums){
            if(num == 0){
                curCount = 0;
                continue;
            }
            curCount++;
            maxCount = Math.max(curCount, maxCount);
        }
        return maxCount;
    }
}
```

---

**Runtime** 3 ms (beats 59.1%) · **Memory** 52.9 MB (beats 10.5%)

<sub>Synced by AILeetHub on 2026-09-04.</sub>
