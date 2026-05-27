# 3121. Count the Number of Special Characters II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/count-the-number-of-special-characters-ii/)

`Hash Table` · `String`

## Approach

Accepted medium solution in java.
Relevant topics: Hash Table, String.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {

    public int numberOfSpecialChars(String word) {

        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];

        // initialize
        for (int i = 0; i < 26; i++) {
            lastLower[i] = -1;
            firstUpper[i] = -1;
        }

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {

                lastLower[ch - 'a'] = i;

            } else {

                int idx = ch - 'A';

                // store first uppercase occurrence only
                if (firstUpper[idx] == -1) {
                    firstUpper[idx] = i;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {

            if (lastLower[i] != -1 &&
                firstUpper[i] != -1 &&
                lastLower[i] < firstUpper[i]) {

                count++;
            }
        }

        return count;
    }
}
```

---

**Runtime** 22 ms · **Memory** 48.2 MB

<sub>Synced by AILeetHub on 2026-05-27.</sub>
