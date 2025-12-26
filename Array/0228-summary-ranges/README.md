# 228. Summary Ranges

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/summary-ranges/)

`Array`

## Approach

Accepted easy solution in java.
Relevant topics: Array.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) return ranges;
        if (nums.length == 1) {
            ranges.add(nums[0] + "");
            return ranges;
        }
        int currentIndex = 0;
        for(int rangeStart = 0; rangeStart < nums.length; rangeStart++){
            currentIndex = rangeStart + 1;
            while(currentIndex < nums.length && nums[currentIndex] - nums[currentIndex - 1] == 1){ currentIndex++; }

            if(nums[rangeStart] == nums[currentIndex - 1]){ ranges.add(nums[rangeStart] + ""); }
            else{ ranges.add(nums[rangeStart] + "->" + nums[currentIndex - 1]); }
            rangeStart = currentIndex - 1;
        }
        return ranges;
    }
}
```

---

**Runtime** 3 ms · **Memory** 43.3 MB

<sub>Synced by AILeetHub on 2025-12-26.</sub>
