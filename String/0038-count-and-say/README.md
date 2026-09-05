# 38. Count and Say

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/count-and-say/)

`String`

## Intuition  
The key observation is that each term of the sequence is completely determined by a single left‑to‑right scan of the previous term: while walking, we count how many identical characters appear consecutively and immediately emit “count + character”. This eliminates the need for any extra data structures, extra passes, or recursion beyond the natural definition. The algorithm therefore follows a classic **two‑pointer / run‑length encoding** pattern: one pointer marks the start of a group, the other advances until the group ends.

## Approach  
1. **Base case** – If `n == 1` return `"1"` (the first term).  
2. **Iterative construction** – For each `i` from `2` through `n`:  
   - Initialise `StringBuilder next = new StringBuilder();` and `int count = 1;`.  
   - **Inner loop** (`j` from `1` to `result.length()‑1`):  
     - Invariant: `result[0..j‑1]` has already been encoded into `next`, and `count` holds the size of the current run that ends at `j‑1`.  
     - If `result.charAt(j) == result.charAt(j‑1)`, increment `count`.  
     - Otherwise, append `count` and the character `result.charAt(j‑1)` to `next`, then reset `count = 1` to start a new run.  
   - After the loop, append the final run (`count` and the last character `result.charAt(result.length()‑1)`).  
   - Assign `result = next.toString();` so the next outer iteration works on the freshly built term.  
3. Return `result` after the outer loop finishes.

*Edge handling*: The code explicitly treats an empty or single‑character `result` correctly because the inner loop starts at `j = 1`; for length 1 the loop body never executes, and the final `append` writes the sole run. The `<=` vs `<` choice is irrelevant here because the outer loop uses `i <= n` to include the nth term.

## Dry Run  
Input: `n = 4`

| outer i | result (before) | j | count | next (built so far) | note |
|--------|-----------------|---|-------|---------------------|------|
| 2 | "1" | – | – | "" | start building term 2 |
| – | – | (no j loop, length 1) | – | "" → append 1, '1' → "11" | final run added |
| 3 | "11" | 1 | count=2 (chars equal) | "" → after loop append 2,'1' → "21" | inner loop ends, final run added |
| 4 | "21" | 1 | count=1 (different) → append 1,'2' → "12" then reset count=1 | after loop append 1,'1' → "1211" | final run added |

After the outer loop finishes (`i = 4`), `result` is `"1211"`, which is exactly the 4th count‑and‑say term.

## Complexity  
- **Time:** O(n · L) where L is the length of the final term (≈ 2ⁿ in the worst case). Each outer iteration scans the current string once, so the total work is proportional to the sum of lengths of all intermediate strings.  
- **Space:** O(L) extra, because `next` holds the newly generated term while `result` holds the previous one; no additional data structures are used beyond these strings. (The output string itself is not counted against the auxiliary space.)

## Solution (Java)

```java
// class Solution {
//     public String countAndSay(int n) {
//         String result = "1";
//         for(int i = 2; i <= n; i++){
//             StringBuilder next = new StringBuilder();
//             int count = 1;

//             for(int j = 1; j < result.length(); j++){
//                 if(result.charAt(j) == result.charAt(j - 1)){
//                     count++;
//                 }
//                 else{
//                     next.append(count);
//                     next.append(result.charAt(j-1));
//                     count = 1;
//                 }
//             }
//             next.append(count);
//             next.append(result.charAt(result.length() - 1));
//             result = next.toString();

//         }
//         return result;
//     }
// }

// Better Approach

class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        return nextTerm(countAndSay(n - 1));
    }

    private String nextTerm(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < len) {
            char c = chars[i];
            int count = 1;
            while (i + count < len && chars[i + count] == c) {
                count++;
            }
            sb.append(count).append(c);
            i += count;
        }
        return sb.toString();
    }
}
```

---

**Runtime** 2 ms (beats 99.7%) · **Memory** 43 MB (beats 70.5%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
