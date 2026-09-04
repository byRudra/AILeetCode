# 485. Max Consecutive Ones

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/max-consecutive-ones/)

`Array`

## Intuition  
The key observation is that the length of the current run of 1’s can be maintained incrementally: whenever a 0 appears the run ends and the counter must be reset to 0, otherwise the run length grows by 1. By keeping a second variable that records the largest run seen so far, we obtain the answer in a single left‑to‑right pass. A naïve solution might scan every possible sub‑array or store indices of 1’s, which would require extra passes or O(n) auxiliary space. The insight eliminates both by using two simple integer variables—often described as the “running count” pattern.

## Approach  
1. **Initialize** `maxCount = 0` and `curCount = 0`.  
2. **Iterate** over each element `num` in `nums` (the loop ends when the array is exhausted).  
   - **Invariant** before each iteration: `curCount` equals the length of the consecutive 1’s segment that ends at the previous index, and `maxCount` is the maximum length observed up to that point.  
3. **If** `num == 0`  
   - Set `curCount = 0` to discard the broken segment.  
   - `continue` to the next element; `maxCount` is unchanged because a 0 cannot extend a run.  
4. **Else** (`num == 1`)  
   - Execute `curCount++` to extend the current run.  
   - Update `maxCount = Math.max(curCount, maxCount)`. This ensures `maxCount` always stores the best run seen so far.  
5. After the loop finishes (i.e., all elements processed), **return** `maxCount`.  

Edge considerations handled by the code:  
- The constraints guarantee at least one element, so no explicit empty‑array guard is needed.  
- For a single‑element array the loop runs once, correctly yielding 1 or 0.  
- All‑zero input leaves `maxCount` at its initial 0.  
- All‑one input lets `curCount` grow to `nums.length`, and `maxCount` follows it.  

## Dry Run  
**Input:** `nums = [1, 1, 0, 1, 1, 1]`

| i (index) | num | curCount (after step) | maxCount (after step) | note |
|-----------|-----|-----------------------|-----------------------|------|
| 0 | 1 | 1 | 1 | start first run |
| 1 | 1 | 2 | 2 | extend run |
| 2 | 0 | 0 | 2 | reset on zero |
| 3 | 1 | 1 | 2 | new run begins |
| 4 | 1 | 2 | 2 | run length matches current max |
| 5 | 1 | 3 | 3 | run exceeds previous max |

After processing the last element, `maxCount` equals 3, which is the length of the longest consecutive block of 1’s.

## Complexity  
- **Time:** O(n) – the `for` loop visits each of the `n` elements exactly once, and the body performs only constant‑time operations.  
- **Space:** O(1) – only two integer variables (`maxCount` and `curCount`) are used regardless of input size; the output array is not counted.

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
