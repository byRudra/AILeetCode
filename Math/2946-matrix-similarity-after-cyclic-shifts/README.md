# 2946. Matrix Similarity After Cyclic Shifts

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/)

`Array` · `Math` · `Matrix` · `Simulation`

## Intuition  
A cyclic shift by one position on a row is equivalent to rotating the row’s indices.  
After `n` such shifts (where `n` is the number of columns) the row returns to its original order, so only `k mod n` shifts matter.  
Even‑indexed rows shift left, odd‑indexed rows shift right; the two directions can be handled with a single modulo expression.

## Approach  
1. Compute `shift = k % n`. If `shift` is zero, the matrix is unchanged, so return `True`.  
2. Iterate over every row `i` and every column `j`.  
   * For an even row (`i % 2 == 0`), the element that should appear at column `j` after the shift is originally at column `(j + shift) % n`.  
   * For an odd row, the element that should appear at column `j` comes from column `(j - shift + n) % n`.  
3. Compare `mat[i][j]` with the corresponding original element. If any pair differs, return `False`.  
4. If all comparisons succeed, return `True`.

This direct comparison avoids constructing shifted rows, keeping the algorithm simple and efficient.

## Complexity  
- **Time:** O(m × n) – every cell is inspected once.  
- **Space:** O(1) – only a few integer variables are used, independent of matrix size.

## Solution (python3)

```python
class Solution:
    def areSimilar(self, mat: List[List[int]], k: int) -> bool:
        m = len(mat)
        n = len(mat[0])
        shift = k % n
        if shift == 0 : return True

        for i in range(m):
            for j in range(n):
                if i % 2 == 0:
                    if mat[i][j] != mat[i][(j + shift) % n]:
                        return False
                else:
                    if mat[i][j] != mat[i][(j - shift + n) % n]:
                        return False
        return True

```

---

**Runtime** 3 ms · **Memory** 19.6 MB

<sub>Synced by AILeetHub on 2026-04-10.</sub>
