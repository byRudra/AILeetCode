# 100. Same Tree

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/same-tree/)

`Tree` · `Depth-First Search` · `Breadth-First Search` · `Binary Tree`

## Intuition
Two trees are identical only if every corresponding pair of nodes has the same value and the same structure.  
A natural way to verify this is to walk both trees simultaneously, comparing nodes as we go. If at any point the nodes differ, the trees cannot be the same.

## Approach
The solution uses a simple recursive depth‑first search:

1. **Base cases**  
   * If both nodes are `null`, the subtrees are identical → return `true`.  
   * If one node is `null` and the other is not, the structures differ → return `false`.  
2. **Value check**  
   If the current nodes’ values differ, return `false`.  
3. **Recurse**  
   Recursively compare the left children and the right children.  
   The overall result is the logical AND of the two recursive calls.

Because the recursion visits each node exactly once and performs only constant‑time work per node, the algorithm is straightforward and efficient.

## Complexity
- **Time:** O(n) – each of the n nodes in the trees is visited once.  
- **Space:** O(h) – recursion stack depth equals the height h of the trees (worst‑case O(n) for a skewed tree, best‑case O(log n) for a balanced tree).

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
    

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){ return p == q;}
        if(p.val != q.val){return false; }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);

    }
    
}
```

---

**Runtime** 0 ms · **Memory** 41 MB

<sub>Synced by AILeetHub on 2025-04-07.</sub>
