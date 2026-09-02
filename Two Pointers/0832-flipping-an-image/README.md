# 832. Flipping an Image

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/flipping-an-image/)

`Array` · `Two Pointers` · `Bit Manipulation` · `Matrix` · `Simulation`

## Intuition  
Reversing a row and inverting its bits can be done together.  
If we look at a row from both ends, swapping the two symmetric elements while flipping them produces the desired result in one pass.  
Because the matrix is square, each row can be treated independently, and the whole operation can be performed in place.

## Approach  
For every row in the matrix, initialise two pointers: `left` at the first element and `right` at the last.  
While `left` is less than or equal to `right`, store the value at `left`.  
Set `row[left]` to the inverted value of `row[right]` (`1 - row[right]`) and set `row[right]` to the inverted stored value (`1 - temp`).  
Move `left` forward and `right` backward.  
When the loop finishes, the row has been both reversed and inverted.  
Repeat this for all rows and return the modified matrix.

## Complexity  
- **Time:** O(n²) – each of the n rows of length n is processed once.  
- **Space:** O(1) – only a handful of integer variables are used; the matrix is updated in place.

## Solution (java)

```java
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int row[] : image){
            int left = 0;
            int right = row.length - 1;
            while(left <= right){
                int temp  = row[left];
                row[left] = 1 - row[right];
                row[right] = 1 - temp; 

                left++;
                right--;
            }

        }
        return image;
    }
}
```

---

**Runtime** 0 ms · **Memory** 45.5 MB

<sub>Synced by AILeetHub on 2026-09-02.</sub>
