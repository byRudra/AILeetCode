# 141. Linked List Cycle

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/linked-list-cycle/)

`Hash Table` · `Linked List` · `Two Pointers` · `Floyd's Cycle Finding Algorithm`

## Intuition  
If we advance one pointer (`slow`) one node per step and another pointer (`fast`) two nodes per step, then after *k* iterations `fast` has traveled exactly twice as far as `slow`. In a cyclic list the two pointers must eventually occupy the same node because the distance between them shrinks modulo the cycle length. If the list terminates, `fast` will hit `null` before any meeting can occur. The naïve solution would store every visited node in a hash set, costing O(n) extra memory; the two‑pointer invariant eliminates that extra pass and the auxiliary storage.

## Approach  
1. **Handle trivial inputs.**  
   - If `head` is `null` or `head.next` is `null` we return `false` immediately because a list with 0 or 1 node cannot contain a cycle.  
2. **Initialize pointers.**  
   - `slow` starts at `head`.  
   - `fast` starts at `head.next` so that the first comparison inside the loop does not succeed trivially when the list has no cycle.  
3. **Iterate while a forward move is possible.**  
   - Loop condition: `fast != null && fast.next != null`. This guarantees that `fast.next.next` is safe to evaluate.  
   - **Invariant:** at the start of each iteration `slow` is *k* steps from the head and `fast` is *2k* steps from the head (or `null` if the list ended).  
   - Inside the loop:  
     a. If `slow == fast` we have found a meeting point → return `true`.  
     b. Advance `slow` one step: `slow = slow.next`.  
     c. Advance `fast` two steps: `fast = fast.next.next`.  
4. **Terminate without meeting.**  
   - When the loop exits, either `fast` is `null` or `fast.next` is `null`, meaning the list reached its end without looping. Return `false`.  

Key pitfalls addressed: the early `head.next` check avoids a false positive on a single‑node list; the `fast != null && fast.next != null` guard prevents a `NullPointerException` on the final iteration; starting `fast` one node ahead ensures the first equality test does not succeed on a non‑cyclic list of length two.

## Dry Run  
**Input:** `head = [3 → 2 → 0 → -4]` with `-4.next` pointing back to the node containing `2` (cycle length 3).

| iter | slow.val | fast.val | note |
|------|----------|----------|------|
| 0    | 3        | 2        | initial positions (`slow = head`, `fast = head.next`) |
| 1    | 2        | 2        | `slow = slow.next` (2), `fast = fast.next.next` (2) → meet, return `true` |

The algorithm stops after the first iteration because the pointers coincide at the node with value 2, confirming the presence of a cycle.

## Complexity  
- **Time:** O(n) – each iteration moves `slow` one step and `fast` two steps, so at most `n/2` iterations are performed before `fast` reaches the list end or a meeting occurs.  
- **Space:** O(1) – only two extra references (`slow`, `fast`) are used regardless of list size. (The output boolean does not count toward space.)

## Solution (Java)

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
```

---

**Runtime** 0 ms (beats 100.0%) · **Memory** 46.7 MB (beats 52.9%)

<sub>Synced by AILeetHub on 2026-06-18.</sub>
