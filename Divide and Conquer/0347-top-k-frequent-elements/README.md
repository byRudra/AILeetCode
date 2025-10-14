# 347. Top K Frequent Elements

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/top-k-frequent-elements/)

`Array` · `Hash Table` · `Divide and Conquer` · `Sorting` · `Heap (Priority Queue)` · `Bucket Sort` · `Counting` · `Quickselect`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Hash Table, Divide and Conquer, Sorting, Heap (Priority Queue), Bucket Sort, Counting, Quickselect.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> NumMap = new HashMap<>();
        // Counting Frequency 
        for (int x : nums) {
            NumMap.put(x, NumMap.getOrDefault(x, 0) + 1);
        }
        // creating a bucket
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : NumMap.keySet()){
            int freq = NumMap.get(key);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        // Return Top 'K' elements 
        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }return result.stream().mapToInt(Integer::intValue).limit(k).toArray();
    }
}
```

---

**Runtime** 14 ms · **Memory** 48.8 MB

<sub>Synced by AILeetHub on 2025-10-14.</sub>
