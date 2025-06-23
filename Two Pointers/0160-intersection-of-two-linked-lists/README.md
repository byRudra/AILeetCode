# 160. Intersection of Two Linked Lists

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/intersection-of-two-linked-lists/)

`Hash Table` · `Linked List` · `Two Pointers`

## Intuition
The two lists share a common tail when they intersect.  
If we walk through each list with a pointer that, upon reaching the end, starts at the head of the other list, both pointers will traverse the same total distance.  
When the lists intersect, the pointers will meet at the first shared node; if they never intersect, both will reach `null` simultaneously.

## Approach
1. Return `null` immediately if either head is `null`.  
2. Initialize two pointers, `pA` at `headA` and `pB` at `headB`.  
3. While `pA` is not equal to `pB`:
   * Move `pA` to `pA.next`; if it becomes `null`, redirect it to `headB`.  
   * Move `pB` to `pB.next`; if it becomes `null`, redirect it to `headA`.  
4. When the loop exits, `pA` (and `pB`) is either the intersection node or `null`. Return it.

This technique guarantees that both pointers travel the same number of nodes (`m + n`), aligning them at the intersection point if one exists.

## Complexity
- **Time:** O(m + n) – each pointer visits at most `m + n` nodes.  
- **Space:** O(1) – only two constant‑size pointers are used.

## Solution (java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// !! APPROACH 1 - BRUTE FORCE

// public class Solution {
//     private int countNodes(ListNode head){
//         int count = 0;
//         ListNode temp = head;
//         while(temp != null){
//             temp = temp.next;
//             count++;            
//         }
//         return count;
//     }
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         int countA = countNodes(headA);
//         int countB = countNodes(headB);
//         int diff;
//         if (countA > countB) {
//             diff = countA - countB;
//             for(int i = 0; i < diff; i++){
//                 headA = headA.next;
//             }
//         } else {
//             diff = countB - countA;
//             for(int i = 0; i < diff; i++){
//                 headB = headB.next;
//             }
//         }

//         while(headA != null || headB != null){
//             if(headA == headB){return headA;}
//             headA = headA.next;
//             headB = headB.next;
//         }
//         return null;
//     }
// }

// APPROACH 2 - TWO POINTER APPROACH

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == null || headB == null) return null;

        ListNode TempA = headA;
        ListNode TempB = headB;
        
        while (TempA != TempB ){
            TempA = (TempA == null) ? headB : TempA.next;
            TempB = (TempB == null) ? headA : TempB.next;
        }

        return TempA;
    }
}
```

---

**Runtime** 1 ms · **Memory** 48.2 MB

<sub>Synced by AILeetHub on 2025-06-23.</sub>
