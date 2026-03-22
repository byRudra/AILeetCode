# 3643. Flip Square Submatrix Vertically

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/flip-square-submatrix-vertically/)

`Array` · `Two Pointers` · `Matrix`

## Intuition  
Flipping a square submatrix vertically means exchanging its top rows with the corresponding bottom rows while keeping columns in place. The operation is symmetric: the first row swaps with the last, the second with the second‑last, and so on. Only the rows inside the `k × k` region are affected; the rest of the matrix stays unchanged.

## Approach  
Iterate over the first half of the submatrix rows (`i` from `0` to `k//2 - 1`). For each such row, compute its counterpart row index `x + k - i - 1`. Then loop over all columns `j` of the submatrix (`0` to `k-1`) and swap the elements `grid[x + i][y + j]` and `grid[x + k - i - 1][y + j]` using tuple assignment. This in‑place swap reverses the order of rows vertically. After completing the loops, return the modified `grid`.

## Complexity  
- **Time:** O(k²) – each of the k² elements in the submatrix is visited once for a constant‑time swap.  
- **Space:** O(1) – the algorithm uses only a few integer variables and performs swaps in place without extra storage.

## Solution (python3)

```python
class Solution:
    def reverseSubmatrix(self, grid: List[List[int]], x: int, y: int, k: int) -> List[List[int]]:
        for i in range(k//2):
            for j in range(k):
                grid[i +  x][y + j],grid[x + k - i - 1][y + j]  = grid[x + k - i - 1][y + j],grid[i + x][y + j] 

        return grid
```

---

**Runtime** 0 ms · **Memory** 19.6 MB

<sub>Synced by AILeetHub on 2026-03-22.</sub>
