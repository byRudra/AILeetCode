# 101. Symmetric Tree

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/symmetric-tree/)

`Tree` · `Depth-First Search` · `Breadth-First Search` · `Binary Tree`

## Intuition  
A binary tree is symmetric if the left subtree is a mirror image of the right subtree.  
Mirroring swaps the left and right children at every level, so two subtrees are equal as mirrors when:

1. Their root values match.
2. The left child of one equals the right child of the other, and vice‑versa.

The algorithm checks this property recursively.

## Approach  
1. If the root is `null`, the tree is symmetric.  
2. Recursively compare `root.left` and `root.right` using a helper `isSameTree`.  
3. In `isSameTree(p, q)`:
   * If both nodes are `null`, they match.  
   * If only one is `null` or their values differ, symmetry fails.  
   * Otherwise, recursively compare `p.right` with `q.left` **and** `p.left` with `q.right`.  
4. The recursion stops when all corresponding node pairs satisfy the mirror condition, returning `true`; any mismatch returns `false`.

This depth‑first traversal naturally follows the tree structure, ensuring each node is examined once.

## Complexity  
- **Time:** O(n) – every node is visited once.  
- **Space:** O(h) – recursion stack depth equals the tree height (worst‑case O(n) for a skewed tree).

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){ return true;}
        return isSameTree(root.left, root.right);
    }
     public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){ return p == q;}
        if(p.val != q.val){return false; }
        return isSameTree(p.right, q.left) && isSameTree(p.left, q.right);

    }
}
```

---

**Runtime** 0 ms · **Memory** 42.1 MB

<sub>Synced by AILeetHub on 2025-04-07.</sub>
