# 485. Max Consecutive Ones

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/max-consecutive-ones/)

`Array`

## Intuition  
The longest run of 1’s can be discovered by scanning the array once while keeping track of the length of the current run. Whenever a 0 appears the current run ends and must be reset. The maximum of all observed runs is the answer.

## Approach  
Initialize `maxCount` and `curCount` to 0. Iterate through `nums` with a for‑each loop.  
- If the element is 0, set `curCount` back to 0 and continue to the next element.  
- If the element is 1, increment `curCount`. After the increment, update `maxCount` with `Math.max(curCount, maxCount)`.  

At the end of the traversal, `maxCount` holds the length of the longest consecutive sequence of 1’s, which is returned.

## Complexity  
- **Time:** O(n) – each element is examined exactly once.  
- **Space:** O(1) – only two integer variables are used regardless of input size.

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

**Runtime** 3 ms (beats 59.1%) · **Memory** 52.7 MB (beats 26.3%)

<sub>Synced by AILeetHub on 2026-09-04.</sub>
