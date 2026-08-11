# 54. Spiral Matrix

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/spiral-matrix/)

`Array` · `Matrix` · `Simulation`

## Intuition
Spiral traversal can be visualized as peeling layers from the outermost ring inward.  
At any moment we know the current boundaries of the remaining sub‑matrix: the topmost row, bottommost row, leftmost column, and rightmost column.  
By walking along these four edges in order—top row left→right, right column top→bottom, bottom row right→left, left column bottom→top—we visit all elements of the current layer.  
After completing a layer we shrink the boundaries and repeat until no rows or columns remain.

## Approach
1. Initialize four pointers: `top = 0`, `bottom = m‑1`, `left = 0`, `right = n‑1`.  
2. While `left <= right` and `top <= bottom`:
   * Traverse the top row from `left` to `right`, appending each element; then `top++`.  
   * Traverse the right column from `top` to `bottom`, appending each element; then `right--`.  
   * If `top <= bottom`, traverse the bottom row from `right` to `left`, appending each element; then `bottom--`.  
   * If `left <= right`, traverse the left column from `bottom` to `top`, appending each element; then `left++`.  
3. Return the accumulated list.

The algorithm visits every cell exactly once and updates the four boundaries after each layer, guaranteeing correct order without revisiting elements.

## Complexity
- **Time:** O(m × n) – each of the `m × n` elements is processed once.  
- **Space:** O(1) – only a few integer pointers are used; the output list is required by the problem.

## Solution (java)

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, right = matrix[0].length - 1, left = 0;
        while((left <= right) && (top <= bottom)){
            for(int i = left; i <= right; i++){
                spiralList.add(matrix[top][i]);
            }
            top++;

            for(int j = top; j <= bottom; j++){
                spiralList.add(matrix[j][right]);
            }
            right--;
            if(top <= bottom){
            for(int k = right; k >= left; k--){
                spiralList.add(matrix[bottom][k]);
            }
            bottom--;
            }
            if(left <= right){
            for(int l = bottom; l >= top; l--){
                spiralList.add(matrix[l][left]);
            }
            left++;

            }
        }
        return spiralList;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.2 MB

<sub>Synced by AILeetHub on 2026-08-11.</sub>
