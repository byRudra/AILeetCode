# 1051. Height Checker

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/height-checker/)

`Array` · `Sorting` · `Counting Sort` · `Bubble Sort`

## Intuition
The task is to count how many students are standing in a different position than they would if the line were sorted by height. If we could view the sorted order, we could simply compare it with the current order and tally the mismatches.

## Approach
The solution follows a three‑step process:

1. **Copy the input** – `heights.clone()` creates a new array with the same values, preserving the original order for later comparison.
2. **Sort the copy** – `Arrays.sort(expectedHeight)` rearranges the clone into non‑decreasing order, producing the expected lineup.
3. **Count mismatches** – A single `for` loop walks through the indices. Whenever `expectedHeight[i]` differs from `heights[i]`, a counter is incremented. After the loop, the counter equals the number of indices where the current order deviates from the expected order.

The algorithm uses Java’s dual‑pivot quicksort for sorting, which is efficient for the given constraints.

## Complexity
- **Time:** O(n log n) – sorting dominates the runtime; the subsequent scan is linear.  
- **Space:** O(n) – the cloned array stores a full copy of the input; no other significant allocations are made.

## Solution (java)

```java
class Solution {
    public int heightChecker(int[] heights) {
        int expectedHeight[] =  heights.clone();;
        Arrays.sort(expectedHeight);
        int count = 0;
        for(int i = 0; i < heights.length; i++){
            if(expectedHeight[i] != heights[i]) count++;
        }
        return count;
    }
}
```

---

**Runtime** 4 ms · **Memory** 43.8 MB

<sub>Synced by AILeetHub on 2026-08-24.</sub>
