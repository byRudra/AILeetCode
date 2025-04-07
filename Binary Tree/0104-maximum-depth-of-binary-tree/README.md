# 104. Maximum Depth of Binary Tree

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

`Tree` · `Depth-First Search` · `Breadth-First Search` · `Binary Tree`

## Intuition  
The depth of a node equals one plus the maximum depth of its children. A leaf node has depth 1, and an empty subtree contributes 0. By applying this rule recursively from the leaves upward, we can determine the maximum depth of the entire tree.

## Approach  
The algorithm performs a depth‑first traversal using recursion.  
1. If the current node is `null`, return 0.  
2. Recursively compute the depth of the left subtree.  
3. Recursively compute the depth of the right subtree.  
4. Return `1 + max(leftDepth, rightDepth)` for the current node.  
The public method initiates the recursion at the root and returns the computed depth. This bottom‑up strategy visits each node once and aggregates depths naturally.

## Complexity  
- **Time:** O(n) – each node is visited once during the recursion.  
- **Space:** O(h) – recursion stack depth equals the height of the tree, which is at most n in the worst case.

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
    public int maxDepth(TreeNode root) {
        int count = 0;
        if (root == null){ return count;}
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left,right);
    }
}
```

---

**Runtime** 0 ms · **Memory** 42.5 MB

<sub>Synced by AILeetHub on 2025-04-07.</sub>
