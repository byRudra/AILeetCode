# 1189. Maximum Number of Balloons

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/maximum-number-of-balloons/)

`Hash Table` · `String` · `Counting`

## Intuition
To form the word **“balloon”** we need one `b`, one `a`, two `l`s, two `o`s, and one `n`.  
The maximum number of copies that can be built is limited by the scarcest of these required letters.  
Thus, after counting how many times each letter appears in the input, the answer is the minimum of  
`count(b)`, `count(a)`, `count(n)`, `count(l)/2`, and `count(o)/2`.

## Approach
1. Create an integer array `freq[26]` to store the frequency of each lowercase letter.  
2. Iterate over the characters of `text`, incrementing the corresponding slot in `freq`.  
3. Compute the usable counts for the letters that matter:  
   - `b = freq['b'-'a']`  
   - `a = freq['a'-'a']`  
   - `l = freq['l'-'a'] / 2` (each balloon needs two `l`s)  
   - `o = freq['o'-'a'] / 2` (each balloon needs two `o`s)  
   - `n = freq['n'-'a']`  
4. Return the minimum of these five values, which is the maximum number of complete “balloon” words that can be formed.

## Complexity
- **Time:** O(n) – one pass over the string of length *n* and constant‑time calculations.  
- **Space:** O(1) – a fixed 26‑element array regardless of input size.

## Solution (java)

```java
// class Solution {
//     public int maxNumberOfBalloons(String text) {
//         HashMap<Character, Integer> listChar = new HashMap<>();
//         for(char ch : text.toCharArray()){
//             listChar.put(ch, listChar.getOrDefault(ch, 0) + 1);
//         }
//         int b = listChar.getOrDefault('b', 0);
//         int a = listChar.getOrDefault('a', 0);
//         int l = listChar.getOrDefault('l', 0) / 2;
//         int o = listChar.getOrDefault('o', 0) / 2;
//         int n = listChar.getOrDefault('n', 0);

//         return Math.min(
//             Math.min(
//                 Math.min(b,a),
//                 Math.min(l,o)
//             ),
//             n
//         );
//     }
// }

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }

        return Math.min(
            Math.min(freq['b' - 'a'], freq['a' - 'a']),
            Math.min(
                Math.min(freq['l' - 'a'] / 2,
                         freq['o' - 'a'] / 2),
                freq['n' - 'a']
            )
        );
    }
}
```

---

**Runtime** 2 ms · **Memory** 43.4 MB

<sub>Synced by AILeetHub on 2026-06-22.</sub>
