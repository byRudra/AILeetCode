# 168. Excel Sheet Column Title

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/excel-sheet-column-title/)

`Math` · `String`

## Approach

Accepted easy solution in java.
Relevant topics: Math, String.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder number = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            int temp = columnNumber % 26;
            number.insert(0, (char) ('A' + temp));
            columnNumber = columnNumber / 26;
        }
        return number.toString();
    }
}
```

---

**Runtime** 0 ms · **Memory** 40.6 MB

<sub>Synced by AILeetHub on 2025-06-23.</sub>
