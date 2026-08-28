# 49. Group Anagrams

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/group-anagrams/)

`Array` · `Hash Table` · `String` · `Sorting`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Hash Table, String, Sorting.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> resultContainer = new HashMap<>();

        for (String word : strs) {
            char ch[] = word.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            resultContainer.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(resultContainer.values());
    }
}
```

---

**Runtime** 7 ms · **Memory** 49.7 MB

<sub>Synced by AILeetHub on 2026-08-28.</sub>
