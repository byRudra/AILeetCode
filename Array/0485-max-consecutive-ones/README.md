# 485. Max Consecutive Ones

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/max-consecutive-ones/)

`Array`

## Intuition  
The key observation is that the length of the current run of 1’s can be maintained incrementally: every time a 0 appears the run ends and the counter must be reset to 0, otherwise the run simply grows by 1. While scanning the array we can also keep the best run seen so far. A naïve solution might examine every possible sub‑array or store prefix information, both of which would require extra passes or additional memory. By recognizing that the “current run length” is enough to decide the answer, we eliminate the need for any auxiliary data structures and finish in a single linear scan. This is the classic two‑state (current vs. best) linear‑scan pattern.

## Approach  
1. **Initialize** `maxCount = 0` and `curCount = 0`.  
2. **Iterate** over each element `num` in `nums` using the enhanced `for` loop.  
   - **Exit condition**: the loop terminates after the last element; no early break is needed.  
   - **Invariant** after processing index *i*: `curCount` equals the length of the consecutive 1’s that end exactly at position *i*, and `maxCount` equals the maximum length observed among all positions ≤ *i*.  
3. **Handle a zero**: if `num == 0`, set `curCount = 0` and `continue` to the next iteration. This resets the run because a 0 cannot belong to any consecutive‑1 segment.  
4. **Handle a one**: otherwise (`num == 1`), increment `curCount++`.  
5. **Update the best**: assign `maxCount = Math.max(curCount, maxCount)`. This preserves the larger of the previous best and the newly extended run.  
6. **Return** `maxCount` after the loop finishes.  

**Edge‑case decisions**:  
- The constraints guarantee `nums.length ≥ 1`, so an explicit empty‑array guard is unnecessary.  
- For a single‑element array the loop runs once, correctly yielding `1` if the element is 1 or `0` otherwise.  
- All‑zero input leaves `maxCount` at its initial 0, which is the correct answer.  
- All‑one input lets `curCount` grow to `n`; `maxCount` follows it, yielding `n`.  
- No overflow concerns because the counters never exceed `n ≤ 10⁵`, well within Java’s `int` range.

## Dry Run  

**Input**: `nums = [1, 1, 0, 1, 1, 1]`

| i | num | curCount (after step) | maxCount (after step) | note                         |
|---|-----|-----------------------|-----------------------|------------------------------|
| 0 | 1   | 1                     | 1                     | start first run              |
| 1 | 1   | 2                     | 2                     | extend run to length 2       |
| 2 | 0   | 0                     | 2                     | reset because of zero        |
| 3 | 1   | 1                     | 2                     | new run starts               |
| 4 | 1   | 2                     | 2                     | run length matches current max|
| 5 | 1   | 3                     | 3                     | run exceeds previous max      |

After processing the last element, `maxCount` equals 3, which is the length of the longest consecutive block of 1’s.

## Complexity  
- **Time:** **O(n)** – the `for` loop visits each of the `n` elements exactly once, and all operations inside the loop are O(1).  
- **Space:** **O(1)** – only two integer variables (`maxCount` and `curCount`) are used regardless of input size; the output integer does not count toward extra space.

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

**Runtime** 3 ms (beats 59.1%) · **Memory** 52.3 MB (beats 84.1%)

<sub>Synced by AILeetHub on 2026-09-04.</sub>
