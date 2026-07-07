# 229. Majority Element II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/majority-element-ii/)

`Array` · `Hash Table` · `Sorting` · `Counting` · `Boyer–Moore Majority Vote Algorithm`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Hash Table, Sorting, Counting, Boyer–Moore Majority Vote Algorithm.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int threshold = nums.length / 3;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > threshold){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
```

---

**Runtime** 14 ms · **Memory** 51 MB

<sub>Synced by AILeetHub on 2026-07-07.</sub>
