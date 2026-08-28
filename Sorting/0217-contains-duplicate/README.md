# 217. Contains Duplicate

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/contains-duplicate/)

`Array` · `Hash Table` · `Sorting`

## Intuition  
A duplicate exists if any value appears more than once.  
The most direct way to detect this is to remember every number seen so far and check each new number against that memory.  
If the number is already remembered, a duplicate has been found; otherwise we record it and continue.

## Approach  
The solution uses a `HashSet` to store the integers encountered while iterating through the array once.  
For each element `num` in `nums`:
1. Query the set; if `num` is already present, return `true` immediately.  
2. If not present, insert `num` into the set.  
If the loop finishes without finding a repeat, return `false`.  
The set guarantees O(1) average‑time membership checks and insertions, allowing the algorithm to finish in a single pass.

## Complexity  
- **Time:** O(n) – each of the n elements is processed once with constant‑time set operations.  
- **Space:** O(n) – in the worst case all elements are distinct, so the set stores n integers.

## Solution (java)

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
```

---

**Runtime** 17 ms · **Memory** 108.2 MB

<sub>Synced by AILeetHub on 2026-08-28.</sub>
