# 111. Minimum Depth of Binary Tree

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-depth-of-binary-tree/)

`Tree` · `Depth-First Search` · `Breadth-First Search` · `Binary Tree`

## Intuition
The minimum depth is the length of the shortest root‑to‑leaf path. A leaf has no children, so the depth stops when both left and right are null. The challenge is that a node with only one child cannot be considered a leaf; the path must continue through the existing child. Therefore, when recursing we must treat missing children carefully.

## Approach
The solution uses a depth‑first search that recurses on the tree. For a null node it returns 0. If the current node has only one child, the depth is forced to go through that child, so we return 1 plus the depth of the non‑null child. If both children exist, we compute the depths of each subtree and take the smaller one, adding 1 for the current node. This guarantees that paths ending at a leaf are counted correctly while paths that terminate prematurely (due to a missing child) are ignored. The recursion naturally explores all nodes, and the minimum depth is propagated back up the call stack.

## Complexity
- **Time:** O(n) – every node is visited once.  
- **Space:** O(h) – recursion depth equals the tree height, worst‑case O(n) for a skewed tree.

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
    public int minDepth(TreeNode root) {
        if (root == null){return 0;}
        if (root.left == null){return 1 + minDepth(root.right);}
        if (root.right == null){return 1 + minDepth(root.left);}
        return 1 + Math.min(minDepth(root.right), minDepth(root.left));
    }
}
```

---

**Runtime** 6 ms · **Memory** 63.2 MB

<sub>Synced by AILeetHub on 2025-04-10.</sub>
