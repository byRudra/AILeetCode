# 485. Max Consecutive Ones

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/max-consecutive-ones/)

`Array`

## Intuition
The longest run of 1s can be found by scanning the array once and keeping track of the current streak length. Whenever a 0 is encountered the streak resets, and each time a 1 is seen the streak grows. The maximum streak seen so far is the answer.

## Approach
Traverse the array with a single loop.  
- Maintain `currentConsecutive` for the length of the current run of 1s.  
- Maintain `maxConsecutive` for the longest run found so far.  
For each element:
1. If it is 1, increment `currentConsecutive` and update `maxConsecutive` if the new streak is longer.  
2. If it is 0, reset `currentConsecutive` to 0 because the streak is broken.  
After the loop, `maxConsecutive` holds the maximum number of consecutive 1s.

## Complexity
- **Time:** O(n) – each element is examined once.  
- **Space:** O(1) – only two integer counters are used regardless of input size.

## Solution (java)

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int currentConsecutive = 0;
        for(int num: nums){
            if(num == 1){
                currentConsecutive++;
                maxConsecutive = Math.max(currentConsecutive, maxConsecutive);
            }
            else{
                currentConsecutive = 0;
            }
        }
        return maxConsecutive;
    }
}
```

---

**Runtime** 3 ms · **Memory** 52.5 MB

<sub>Synced by AILeetHub on 2026-05-07.</sub>
