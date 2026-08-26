# 2904. Shortest and Lexicographically Smallest Beautiful String

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/)

`String` · `Sliding Window`

## Approach

Accepted medium solution in java.
Relevant topics: String, Sliding Window.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int start = 0;
        int kCount = 0;
        int ansStart = -1;
        int ansLength = Integer.MAX_VALUE;
        for (int end = 0; end < s.length(); end++) {
            if (s.charAt(end) == '1')
                kCount++;

            while (kCount > k) {
                if (s.charAt(start) == '1')
                    kCount--;
                start++;
            }

            while (kCount == k && s.charAt(start) == '0')
                start++;

            if (kCount == k && s.charAt(end) == '1') {
                int length = end - start + 1;
                String current = s.substring(start, end + 1);
                if (ansLength > length || (length == ansLength
                        && current.compareTo(s.substring(ansStart, ansStart + ansLength)) < 0)) {

                    ansLength = length;
                    ansStart = start;
                }
            }
        }
        return ansStart == -1 ? "" : s.substring(ansStart, ansStart + ansLength);

    }
}
```

---

**Runtime** 2 ms · **Memory** 44.2 MB

<sub>Synced by AILeetHub on 2026-08-26.</sub>
