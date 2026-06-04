# 112. Path Sum

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/path-sum/)

`Tree` · `Depth-First Search` · `Breadth-First Search` · `Binary Tree`

## Intuition  
The problem asks whether any root‑to‑leaf path sums to a given target.  
Because the tree is binary, each node has at most two children, so a depth‑first traversal naturally explores every possible path.  
At each step we only need to know the remaining sum required to reach the target; once we reach a leaf we can compare the accumulated sum with the target.

## Approach  
The solution performs a recursive depth‑first search.  
1. If the current node is `null`, no path exists → return `false`.  
2. If the node is a leaf (`left` and `right` are `null`), check whether its value equals the remaining `targetSum`.  
3. Otherwise, recursively call the function on the left and right children, subtracting the current node’s value from `targetSum`.  
The result is the logical OR of the two recursive calls: if either subtree contains a valid path, the function returns `true`.

## Complexity  
- **Time:** O(n) – each node is visited once.  
- **Space:** O(h) – recursion stack depth equals the tree height (≤ n).

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.right == null && root.left == null) return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }
}
```

---

**Runtime** 0 ms · **Memory** 45 MB

<sub>Synced by AILeetHub on 2026-06-04.</sub>
