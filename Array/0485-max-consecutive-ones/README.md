# 485. Max Consecutive Ones

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/max-consecutive-ones/)

`Array`

## Intuition  
The key observation is that the length of the current run of `1`s can be maintained while scanning the array once, and any encounter of a `0` instantly terminates that run. Therefore we only need two counters: one (`curCount`) that tracks the length of the ongoing run, and another (`maxCount`) that records the greatest length seen so far. A naïve solution might examine every possible sub‑array or store indices of all `1`s, both of which would require extra passes or additional memory. By resetting `curCount` at each `0` we eliminate the need for any auxiliary data structures, yielding a pure linear‑time, constant‑space algorithm. This follows the classic **single‑pass counting** pattern.

## Approach  
1. **Initialize** `maxCount = 0` and `curCount = 0`.  
2. **Iterate** over each element `num` in `nums` using the enhanced `for` loop. The loop terminates when the iterator has visited the last element.  
   - **Invariant:** At the start of each iteration, `curCount` equals the length of the consecutive `1`s that end immediately before the current index.  
3. **If** `num == 0`  
   - Set `curCount = 0` to discard the previous run.  
   - `continue` to the next iteration, leaving `maxCount` unchanged.  
   - *Why `=` not `-=`?* Because any preceding run is completely invalidated by a `0`.  
4. **Else** (`num == 1`)  
   - Increment `curCount++` to extend the current run.  
   - Update `maxCount = Math.max(curCount, maxCount)`. This ensures `maxCount` always stores the largest run encountered so far.  
5. **After the loop**, return `maxCount`.  
   - Edge handling: The constraints guarantee at least one element, so no special empty‑array guard is needed. The algorithm also works when all entries are `0` (returns `0`) or all are `1` (returns `nums.length`).  

## Dry Run  

**Input:** `nums = [1, 1, 0, 1, 1, 1]`

| Step | `num` | `curCount` (after update) | `maxCount` (after update) | Note |
|------|-------|---------------------------|---------------------------|------|
| 1    | 1     | 1                         | 1                         | start first run |
| 2    | 1     | 2                         | 2                         | extend run |
| 3    | 0     | 0                         | 2                         | run broken, reset |
| 4    | 1     | 1                         | 2                         | new run begins |
| 5    | 1     | 2                         | 2                         | extend new run |
| 6    | 1     | 3                         | 3                         | extend, new max found |

After processing all elements, `curCount` holds the length of the trailing run (`3`) and `maxCount` holds the overall maximum consecutive `1`s (`3`). The method returns `3`, which matches the expected answer.

## Complexity  
- **Time:** O(n) – the single `for` loop visits each of the `n` elements exactly once, and the body performs only constant‑time operations.  
- **Space:** O(1) – only two integer variables (`maxCount` and `curCount`) are used regardless of input size; the output integer does not count toward extra space.

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
