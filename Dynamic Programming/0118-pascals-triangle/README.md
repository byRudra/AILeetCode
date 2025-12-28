# 118. Pascal's Triangle

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/pascals-triangle/)

`Array` · `Dynamic Programming`

## Approach

Accepted easy solution in java.
Relevant topics: Array, Dynamic Programming.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resMat = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1; j < i; j++){
                int value = resMat.get(i-1).get(j-1) + resMat.get(i-1).get(j);
                row.add(value);
            }
            if(i > 0) row.add(1);
            resMat.add(row);
        }
        return resMat;
    }
}
```

---

**Runtime** 1 ms · **Memory** 43.5 MB

<sub>Synced by AILeetHub on 2025-12-28.</sub>
