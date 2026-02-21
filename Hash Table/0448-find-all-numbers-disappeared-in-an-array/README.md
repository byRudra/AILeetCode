# 448. Find All Numbers Disappeared in an Array

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

`Array` · `Hash Table`

## Intuition  
The array `nums` contains values from 1 to *n*. If we could quickly check whether a particular number appears, we could list all missing ones. A direct way is to record the presence of each value in a separate structure and then scan that structure for gaps.

## Approach  
Create an auxiliary array `marker` of length *n*, initialized to zeros. Iterate over `nums`; for each value `num`, set `marker[num‑1]` to 1, indicating that `num` exists. After marking, traverse `marker` from index 0 to *n*‑1. Whenever an entry remains 0, its index + 1 is a number missing from the original array, so add it to the result list. Finally, return the list of missing numbers.

## Complexity  
- **Time:** O(n) – one pass to mark presence and one pass to collect missing values, each linear in the array size.  
- **Space:** O(n) – the `marker` array stores a flag for each of the *n* possible values.

## Solution (java)

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int marker[] = new int[nums.length];
        for(int num : nums){
            marker[num - 1] = 1;
        }
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < marker.length; i++) {
            if (marker[i] == 0) {
                result.add(i + 1); 
            }
        }

        return result;
    }
}
```

---

**Runtime** 4 ms · **Memory** 70.3 MB

<sub>Synced by AILeetHub on 2026-02-21.</sub>
