# 143. Reorder List

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/reorder-list/)

`Linked List` · `Two Pointers` · `Stack` · `Recursion`

## Intuition  
The list can be split exactly in half by moving one pointer (`fast`) twice as fast as another (`slow`). After the loop finishes, `slow` points to the node just before the second half, guaranteeing that the first half ends where the second half begins regardless of odd or even length. Reversing the second half in‑place then lets us interleave the two halves with a single linear pass, eliminating the need for extra storage, a second traversal to find the tail, or recursion. This is the classic **two‑pointer** (slow/fast) plus in‑place reversal pattern.

## Approach  
1. **Find the midpoint**  
   ```java
   while (fast != null && fast.next != null) {
       slow = slow.next;
       fast = fast.next.next;
   }
   ```  
   *Exit condition*: `fast` reaches the end (`null`) or the node before the end (`fast.next == null`).  
   *Invariant*: after `k` iterations, `fast` has moved `2k` nodes and `slow` `k` nodes, so `slow` always trails exactly half the distance traversed.

2. **Detach and reverse the second half**  
   ```java
   ListNode curr = slow.next;
   ListNode prev = null;
   slow.next = null;          // split the list
   while (curr != null) {
       ListNode next = curr.next;
       curr.next = prev;
       prev = curr;
       curr = next;
   }
   ```  
   *Exit condition*: `curr` becomes `null`.  
   *Invariant*: `prev` is the head of the reversed prefix of the original second half, while `curr` points to the next node to reverse. The split (`slow.next = null`) guarantees the two halves are independent, preventing cycles.

3. **Merge the two halves alternately**  
   ```java
   ListNode originalList = head;
   while (prev != null) {
       ListNode next1 = originalList.next;
       ListNode next2 = prev.next;

       originalList.next = prev;
       prev.next = next1;

       originalList = next1;
       prev = next2;
   }
   ```  
   *Exit condition*: `prev` (the reversed second half) is exhausted.  
   *Invariant*: before each iteration, `originalList` points to the next node of the first half to be linked, and `prev` points to the next node of the reversed second half. The loop stitches `prev` after `originalList`, then advances both pointers.

   Edge cases:  
   - **Single node**: the first `while` ends immediately; `slow.next` is `null`, the reverse loop does nothing, and the merge loop skips because `prev` is `null`.  
   - **Odd length**: the middle node stays at the end of the first half because `slow` stops on it; the reversed second half is one node shorter, so the final merge leaves the middle node correctly positioned.  

## Dry Run  
Input: `1 → 2 → 3 → 4`

| Step | slow | fast | curr | prev | originalList | Action |
|------|------|------|------|------|--------------|--------|
| 0 (init) | 1 | 1 | – | – | – | start |
| 1 | 2 | 3 | – | – | – | move slow/fast |
| 2 | 2 | null | 3 | null | – | loop ends, split at 2 |
| 3 | – | – | 3 | null | – | reverse: next=4, 3.next=null, prev=3, curr=4 |
| 4 | – | – | 4 | 3 | – | reverse: next=null, 4.next=3, prev=4, curr=null |
| 5 | – | – | null | 4 | 1 | merge: next1=2, next2=3, 1.next=4, 4.next=2 |
| 6 | – | – | null | 3 | 2 | merge: next1=3, next2=null, 2.next=3, 3.next=3 (no change) |
| 7 | – | – | null | null | – | loop ends |

Final list: `1 → 4 → 2 → 3`, which matches the required ordering.

## Complexity  
- **Time:** O(n) – the fast/slow scan runs n/2 iterations, the reversal runs n/2, and the merge runs at most n/2, all linear in the number of nodes.  
- **Space:** O(1) – only a constant number of pointers (`slow`, `fast`, `curr`, `prev`, `originalList`, `next1`, `next2`) are used; the output list reuses the original nodes.

## Solution (Java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow is the mid point 

        ListNode curr = slow.next;
        ListNode prev = null;

        // making sure the lists are seperate
        slow.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // now merging both of them
        ListNode originalList = head;
        while (prev != null) {
            ListNode next1 = originalList.next;
            ListNode next2 = prev.next;

            originalList.next = prev;
            prev.next = next1;

            originalList = next1;
            prev = next2;
        }
    }
}
```

---

**Runtime** 1 ms (beats 99.8%) · **Memory** 49.4 MB (beats 22.0%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
