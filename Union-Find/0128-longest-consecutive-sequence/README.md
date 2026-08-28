# 128. Longest Consecutive Sequence

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-consecutive-sequence/)

`Array` · `Hash Table` · `Union-Find`

## Intuition
The longest consecutive run can be found by treating each number as a potential sequence start.  
If a number has no predecessor in the set, it must be the smallest element of a run, so we can safely extend forward until the run ends.

## Approach
1. Insert all array elements into a `HashSet` to remove duplicates and enable O(1) membership checks.  
2. Iterate over the set. For each `num`, check whether `num-1` is absent; if so, `num` is the start of a new consecutive sequence.  
3. From that start, repeatedly increment a counter while `num+1`, `num+2`, … are present in the set, counting the length of the run.  
4. Track the maximum run length encountered.  
5. Return the maximum; if the input is empty, return 0.

This method visits each distinct number at most twice—once to identify starts and once while extending runs—ensuring linear time.

## Complexity
- **Time:** O(n) – each element is inserted once and examined at most twice.  
- **Space:** O(n) – the hash set stores all unique numbers.

## Solution (java)

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int longest = 0;
        for (int num : set) {
            if(!set.contains(num - 1)){
                int current = num;
                int currLength = 1;
                while(set.contains(current + 1)){
                    current++;
                    currLength++;
                }
                longest = Math.max(longest, currLength);
            }
        }
        return longest;
    }
}
```

---

**Runtime** 30 ms · **Memory** 95.6 MB

<sub>Synced by AILeetHub on 2026-08-28.</sub>
