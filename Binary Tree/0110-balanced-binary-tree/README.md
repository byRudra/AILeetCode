# 110. Balanced Binary Tree

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/balanced-binary-tree/)

`Tree` · `Depth-First Search` · `Binary Tree`

## Intuition  
A binary tree is balanced if every node’s left and right subtrees differ in height by at most one.  
Instead of checking each node separately, we can compute the height of a subtree while simultaneously verifying its balance. If any subtree is unbalanced, we propagate a special flag (`-1`) upward so that the entire tree is marked unbalanced without further work.

## Approach  
The helper `height(node)` returns the height of `node`’s subtree or `-1` if that subtree is unbalanced.  
1. **Base case**: a null node has height `0`.  
2. Recursively obtain `leftHeight` and `rightHeight`.  
3. If either child returned `-1`, propagate `-1` immediately.  
4. If the absolute difference between `leftHeight` and `rightHeight` exceeds `1`, the current node is unbalanced; return `-1`.  
5. Otherwise, return `1 + max(leftHeight, rightHeight)` as the height of the current subtree.  
The public method `isBalanced` simply checks whether `height(root)` equals `-1` or not.

## Complexity  
- **Time:** O(n) – each node is visited once to compute its height.  
- **Space:** O(h) – recursion stack depth equals the tree’s height (worst‑case O(n) for a skewed tree).

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
    private int height(TreeNode root){
        if (root == null) return 0;

        // cal left height

        int leftHeight = height(root.left);

        // checking if left is unbalanced or not
        if (leftHeight == -1) return -1;

        // similary for right

        // cal right height

        int rightHeight = height(root.right);

        // checking if right is unbalanced or not
        if (rightHeight == -1) return -1;

        // now checking for the current node

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        // now returning the normal height

        return 1 + Math.max(leftHeight, rightHeight); 
    }
    public boolean isBalanced(TreeNode root) {
        int rootHeight;
        return height(root) != -1;
    }
}
```

---

**Runtime** 0 ms · **Memory** 45.6 MB

<sub>Synced by AILeetHub on 2026-05-06.</sub>
