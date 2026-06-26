# 3. Longest Substring Without Repeating Characters

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

`Hash Table` · `String` · `Sliding Window`

## Approach

Accepted medium solution in java.
Relevant topics: Hash Table, String, Sliding Window.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        Set<Character> seenCharacters = new HashSet<>();
        int windowStart = 0, longestSubSequence = 0;

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            char currChar = s.charAt(windowEnd);

            while(seenCharacters.contains(currChar)){
                seenCharacters.remove(s.charAt(windowStart));
                windowStart++;
            }
            seenCharacters.add(currChar);
            longestSubSequence = Math.max(longestSubSequence,windowEnd - windowStart+1);
        }
        return longestSubSequence;

    }
}
```

---

**Runtime** 6 ms · **Memory** 46.3 MB

<sub>Synced by AILeetHub on 2026-06-26.</sub>
