# 119. Pascal's Triangle II

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/pascals-triangle-ii/)

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
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        row.add(1);

        for(int i = 1; i <= rowIndex; i++){
            for(int j = i - 1; j > 0; j--){
                row.set(j, row.get(j-1) + row.get(j));
            }
            row.add(1);
        }
        return row;
    }
}
```

---

**Runtime** 1 ms · **Memory** 42.3 MB

<sub>Synced by AILeetHub on 2026-04-18.</sub>
