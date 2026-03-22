# 1980. Find Unique Binary String

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-unique-binary-string/)

`Array` · `Hash Table` · `String` · `Backtracking`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Hash Table, String, Backtracking.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int length = nums.length;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(nums[i].charAt(i) == '0')
                result.append('1');
            else
                result.append('0');
        }
        return result.toString();
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.1 MB

<sub>Synced by AILeetHub on 2026-03-22.</sub>
