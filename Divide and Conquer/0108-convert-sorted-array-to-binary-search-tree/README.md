# 108. Convert Sorted Array to Binary Search Tree

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)

`Array` · `Divide and Conquer` · `Tree` · `Binary Search Tree` · `Binary Tree`

## Intuition
A sorted array can be turned into a height‑balanced BST by repeatedly picking the middle element as the root.  
Because all elements to the left of the middle are smaller and all to the right are larger, the BST property is preserved.  
Choosing the middle keeps the tree balanced, ensuring the height grows logarithmically with the number of nodes.

## Approach
The solution implements a recursive helper `makeBST(nums, left, right)`:

1. **Base case** – if `left > right`, return `null` (no nodes in this sub‑array).  
2. **Midpoint** – compute `mid = left + (right - left) / 2` to avoid overflow.  
3. **Root node** – create a `TreeNode` with `nums[mid]`.  
4. **Left subtree** – recursively build from `left` to `mid‑1`.  
5. **Right subtree** – recursively build from `mid+1` to `right`.  
6. Return the constructed root.

The public method `sortedArrayToBST` simply calls this helper with the full array bounds.  
Because the array is strictly increasing, the middle element is always a valid BST root, and the recursion naturally produces a balanced tree.

## Complexity
- **Time:** O(n) – each array element is visited once to create a node.  
- **Space:** O(log n) – recursion depth equals the tree height, which is logarithmic for a balanced BST.

## Solution (java)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums, 0, nums.length - 1);
    }
    private TreeNode makeBST(int[] nums, int left, int right){
        if(left > right){return null;}
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeBST(nums, left, mid-1);
        root.right = makeBST(nums, mid+1, right);
        return root;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43.3 MB

<sub>Synced by AILeetHub on 2025-04-08.</sub>
