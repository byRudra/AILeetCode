# 215. Kth Largest Element in an Array

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/kth-largest-element-in-an-array/)

`Array` · `Divide and Conquer` · `Sorting` · `Heap (Priority Queue)` · `Quickselect`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Divide and Conquer, Sorting, Heap (Priority Queue), Quickselect.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
```

---

**Runtime** 70 ms · **Memory** 74.6 MB

<sub>Synced by AILeetHub on 2026-08-25.</sub>
