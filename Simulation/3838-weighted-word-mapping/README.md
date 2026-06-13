# 3838. Weighted Word Mapping

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/weighted-word-mapping/)

`Array` · `String` · `Simulation`

## Intuition
The task reduces to computing a single value for each word: the sum of the given weights of its letters, taken modulo 26.  
Because the mapping is defined in reverse alphabetical order, the remainder `r` directly translates to the character `('z' - r)`.  
Thus, for every word we only need to accumulate its weight, reduce it modulo 26, and append the corresponding character to the answer.

## Approach
1. Create a `StringBuilder` to accumulate the resulting characters.  
2. For each word in the input array:
   * Initialize `sum = 0`.  
   * Iterate over the word’s characters. For each character `ch`, add `weights[ch - 'a']` to `sum`.  
   * Compute `r = sum % 26`.  
   * Convert `r` to the mapped letter with `char mapped = (char)('z' - r)` and append it to the `StringBuilder`.  
3. After processing all words, return the built string.

The algorithm directly follows the problem’s specification, using only a single pass over each word’s characters.

## Complexity
- **Time:** O(total number of characters) – each character is examined once to accumulate its weight.  
- **Space:** O(1) – aside from the output string, only a few integer variables are used.

## Solution (java)

```java
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        for(String word : words){
            int sum = 0;
            for(char ch : word.toCharArray()){
                sum += weights[ch - 'a'];
            }

            result.append((char)('z' - (sum % 26)));
        }
        return result.toString();

    }
}
```

---

**Runtime** 2 ms · **Memory** 46.5 MB

<sub>Synced by AILeetHub on 2026-06-13.</sub>
