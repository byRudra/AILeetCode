# 59. Spiral Matrix II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/spiral-matrix-ii/)

`Array` · `Matrix` · `Simulation`

## Intuition  
The matrix can be filled layer by layer, starting from the outermost ring and spiraling inward. By keeping track of the current top, bottom, left, and right boundaries, we can walk around the perimeter of the remaining sub‑matrix, placing consecutive integers until all cells are filled.

## Approach  
1. Create an `n × n` result array.  
2. Initialize four pointers: `top = 0`, `bottom = n‑1`, `left = 0`, `right = n‑1`, and a counter `currentValue = 1`.  
3. While the boundaries have not crossed (`top ≤ bottom && left ≤ right`):  
   * **Top row** – iterate `i` from `left` to `right`, set `result[top][i] = currentValue++`. Increment `top`.  
   * **Right column** – iterate `j` from `top` to `bottom`, set `result[j][right] = currentValue++`. Decrement `right`.  
   * **Bottom row** – if `top ≤ bottom`, iterate `k` from `right` down to `left`, set `result[bottom][k] = currentValue++`. Decrement `bottom`.  
   * **Left column** – if `left ≤ right`, iterate `l` from `bottom` down to `top`, set `result[l][left] = currentValue++`. Increment `left`.  
4. Repeat until all layers are processed.  
5. Return the filled matrix.

## Complexity  
- **Time:** O(n²) – each of the n² cells is written exactly once.  
- **Space:** O(n²) – the output matrix stores all n² integers.

## Solution (java)

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int result[][] = new int[n][n];

        int top = 0, left = 0, right = n - 1, bottom = n - 1;
        int currentValue = 1;
        while(top <= bottom && left <= right){
            //top
            for(int i = top; i <= right; i++){
                result[top][i] = currentValue++;
            }
            top++;
            for(int j = top; j <= bottom; j++){
                result[j][right] = currentValue++;
            }
            right--;
            if(top <= bottom){
                for(int k = right; k >= left; k--){
                    result[bottom][k] = currentValue++;
                }
                bottom--;
            }
            if(left <= right){
                for(int l = bottom; l >= top; l--){
                    result[l][left] = currentValue++;
                }
                left++;
            }
        }
        return result;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.1 MB

<sub>Synced by AILeetHub on 2026-05-02.</sub>
