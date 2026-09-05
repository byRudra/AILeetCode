# 143. Reorder List

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/reorder-list/)

`Linked List` · `Two Pointers` · `Stack` · `Recursion`

## Intuition  
The list can be split exactly in half by advancing one pointer twice as fast as another; after `k` steps the fast pointer has moved `2k` nodes while the slow pointer has moved `k`, so the slow pointer lands at the midpoint. Once the second half is reversed, the two halves can be interleaved without any extra passes or auxiliary containers. The naïve way—collecting all nodes in an array or using a stack—needs O(n) extra space; the midpoint‑plus‑reverse insight eliminates that overhead while still achieving the required ordering. This is a classic **two‑pointer** technique combined with in‑place reversal.

## Approach  
1. **Find the middle**  
   ```java
   while (fast != null && fast.next != null) {
       slow = slow.next;      // moves one step
       fast = fast.next.next; // moves two steps
   }
   ```  
   *Exit condition*: `fast` reaches the end (`null`) or the node before the end (`fast.next == null`).  
   *Invariant*: `slow` is always exactly half the distance traveled by `fast`, guaranteeing that when the loop stops `slow` points to the last node of the first half (for odd length it is the true middle, for even length it is the left‑middle).  

2. **Detach and reverse the second half**  
   ```java
   ListNode curr = slow.next;
   ListNode prev = null;
   slow.next = null;          // separates the two halves
   while (curr != null) {
       ListNode next = curr.next;
       curr.next = prev;
       prev = curr;
       curr = next;
   }
   ```  
   *Exit condition*: `curr` becomes `null`.  
   *Invariant*: At each iteration the sub‑list starting at `prev` is the reversed prefix of the original second half, while `curr` points to the yet‑unprocessed suffix.  

3. **Merge the two halves alternately**  
   ```java
   ListNode originalList = head;
   while (prev != null) {
       ListNode temp = originalList.next;
       originalList.next = prev;
       originalList = prev;
       prev = prev.next;
       originalList.next = temp;
       originalList = temp;
   }
   ```  
   *Exit condition*: `prev` (the head of the reversed second half) is exhausted.  
   *Invariant*: After each loop iteration the merged list ends with `originalList`, and the next nodes to be linked are `prev` (next from reversed half) and `temp` (next from first half). The code deliberately uses `prev != null` rather than checking `originalList` because the first half may be longer by one node when the original length is odd; the extra node remains correctly at the tail after the loop.

## Dry Run  
Input: `1 → 2 → 3 → 4 → 5`

| Iter | slow | fast | curr (rev) | prev (rev) | originalList | prev (merge) | temp | Action |
|------|------|------|------------|------------|--------------|--------------|------|--------|
| 0 (find mid) | 1 | 1 | – | – | – | – | – | start |
| 1 | 2 | 3 | – | – | – | – | – | slow→2, fast→3 |
| 2 | 3 | 5 | – | – | – | – | – | slow→3, fast→null → stop |
| 3 (reverse) | – | – | 4 | null | – | – | – | curr=4, next=5 |
| 4 | – | – | 5 | 4 | – | – | – | 4.next=null, prev=4, curr=5 |
| 5 | – | – | null | 5→4 | – | – | – | 5.next=4, prev=5, curr=null |
| 6 (merge) | – | – | – | – | 1 | 5 | 2 | 1.next=5, originalList=5 |
| 7 | – | – | – | – | 5 | 4 | 2 | 5.next=2, originalList=2 |
| 8 | – | – | – | – | 2 | null | 3 | 2.next=4, originalList=4 |
| 9 | – | – | – | – | 4 | – | 3 | 4.next=3, originalList=3 |

Final list: `1 → 5 → 2 → 4 → 3`. The merge stops when `prev` becomes `null`; the remaining node `3` is already correctly placed.

## Complexity  
- **Time:** O(n) – the first loop runs n/2 steps, the reversal runs n/2 steps, and the merge runs at most n steps, all linear in the number of nodes.  
- **Space:** O(1) – only a handful of pointers (`slow`, `fast`, `curr`, `prev`, `originalList`, `temp`) are used; no extra data structures proportional to n are allocated. (The output list reuses the original nodes.)

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
            ListNode temp = originalList.next;
            originalList.next = prev;
            originalList = prev;
            prev = prev.next;
            originalList.next = temp;
            originalList = temp;
        }
    }
}
```

---

**Runtime** 2 ms (beats 86.7%) · **Memory** 49.3 MB (beats 36.2%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
