# 2452. Words Within Two Edits of Dictionary

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/words-within-two-edits-of-dictionary/)

`Array` · `String` · `Trie`

## Intuition  
The task is to find, for each query word, whether it can be turned into any dictionary word with at most two single‑letter changes. Since all words share the same length, the number of differing positions between two words directly tells us how many edits are needed. If that number is ≤ 2, the query matches the dictionary.

## Approach  
For every query word `q` we scan the dictionary.  
* Compute `diff`, the count of positions where `q` and a dictionary word `p` differ.  
* If `diff` is 0, 1, or 2, `q` is added to the result list and we stop checking further dictionary words for this query.  
* If no dictionary word satisfies the condition, `q` is omitted.  
The helper `isValid` performs the character‑by‑character comparison and returns `true` when `diff ≤ 2`.

## Complexity  
- **Time:** O(Q · D · L) – each of the Q queries is compared to each of the D dictionary words, and each comparison scans L characters.  
- **Space:** O(1) – aside from the output list, only a few integer variables are used; the algorithm works in place.

## Solution (java)

```java
class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for(String q : queries){
            for(String p : dictionary){
                if(isValid(q, p)){
                    result.add(q);
                    break;
                }
            }
        }
        return result;
    }
    private boolean isValid(String q, String p){
        int diff = 0;
        for(int i = 0; i < q.length(); i++){
            if(q.charAt(i) != p.charAt(i)){
                diff++;
            }
        }
        return diff > 2 ? false : true; 
    }
}
```

---

**Runtime** 13 ms · **Memory** 44.5 MB

<sub>Synced by AILeetHub on 2026-04-22.</sub>
