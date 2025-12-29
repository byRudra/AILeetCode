# 13. Roman to Integer

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/roman-to-integer/)

`Hash Table` · `Math` · `String`

## Approach

Accepted easy solution in java.
Relevant topics: Hash Table, Math, String.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();

        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int value = 0;
        int prevVal = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int currVal = romanMap.get(currChar);

            if (currVal <= prevVal) {
                value += currVal;
            } else {
                value += currVal - 2 * prevVal;
            }
            prevVal = currVal;

        }
        return value;
    }
}
```

---

**Runtime** 4 ms · **Memory** 46.6 MB

<sub>Synced by AILeetHub on 2025-12-29.</sub>
