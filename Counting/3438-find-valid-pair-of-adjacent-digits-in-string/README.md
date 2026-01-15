# 3438. Find Valid Pair of Adjacent Digits in String

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/)

`Hash Table` · `String` · `Counting`

## Approach

Accepted easy solution in java.
Relevant topics: Hash Table, String, Counting.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String findValidPair(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s.length()-1;i++){
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            if(a!=b&& frequency.get(a) == a - '0' && frequency.get(b) == b - '0'){
                return "" + a + b;
            }
        }
        return "";
    }
}
```

---

**Runtime** 5 ms · **Memory** 44.7 MB

<sub>Synced by AILeetHub on 2026-01-15.</sub>
