# 143. Reorder List

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/reorder-list/)

`Linked List` · `Two Pointers` · `Stack` · `Recursion`

## Intuition  
The list can be split exactly in half by advancing one pointer twice as fast as another; after *k* steps the fast pointer has moved `2k` nodes while the slow pointer has moved `k`, so the slow pointer lands at the midpoint. Once the second half is reversed, the two halves can be interleaved in a single pass, producing the required order without any extra containers. The naïve way—collecting all nodes in an array or using a stack—needs O(n) extra space; the midpoint‑reverse‑merge insight eliminates that overhead. This is the classic **two‑pointer + in‑place reversal** pattern.

## Approach  
1. **Find the middle**  
   ```java
   while (fast != null && fast.next != null) {
       slow = slow.next;      // moves one step
       fast = fast.next.next; // moves two steps
   }
   ```  
   *Exit condition*: `fast` reaches the end (`null`) or the node before the end (`fast.next == null`).  
   *Invariant*: `slow` is always exactly half the distance traveled by `fast`. When the loop ends, `slow` points to the last node of the first half.

2. **Detach and reverse the second half**  
   ```java
   ListNode curr = slow.next;
   ListNode prev = null;
   slow.next = null; // break the list
   while (curr != null) {
       ListNode next = curr.next;
       curr.next = prev;
       prev = curr;
       curr = next;
   }
   ```  
   *Exit condition*: `curr` becomes `null`.  
   *Invariant*: Nodes before `prev` are already reversed, nodes after `curr` are untouched. After the loop, `prev` is the head of the reversed second half.

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
   *Exit condition*: `prev` (the reversed half) is exhausted.  
   *Invariant*: The merged prefix ends with `originalList` and `prev` points to the next node to insert. The code always links `originalList → prev → next1`, preserving order and handling odd‑length lists because the first half may be longer by one node.

Edge cases:  
- A single‑node list skips the first loop (`fast.next` is `null`) and the merge loop never runs, leaving the list unchanged.  
- For even length, both halves have equal size; for odd length the first half retains the middle node because `slow` stops before it, and the merge loop naturally stops when `prev` is `null`.

## Dry Run  

**Input**: `1 → 2 → 3 → 4 → 5`

| Iter | slow | fast | curr | prev | originalList | Change |
|------|------|------|------|------|--------------|--------|
| 1 | 2 | 3 | – | – | – | `slow = slow.next`, `fast = fast.next.next` |
| 2 | 3 | 5 | – | – | – | same advance; loop ends (`fast.next == null`) |
| – | – | – | 4 | null | – | detach: `slow.next = null` |
| 1 | – | – | 4 | 4 | – | reverse step: `curr.next = prev` |
| 2 | – | – | 5 | 5 → 4 | – | reverse step |
| 3 | – | – | null | 5 → 4 → null | – | reversal finished, `prev` points to `5` |
| 1 | 1 | – | – | 5 → 4 → null | 1 | merge: `1.next = 5`, `5.next = 2` |
| 2 | 2 | – | – | 4 → null | 2 | merge: `2.next = 4`, `4.next = 3` |
| 3 | 3 | – | – | null | 3 | loop ends (`prev == null`) |

Final list: `1 → 5 → 2 → 4 → 3`, which matches the required ordering.

## Complexity  
- **Time:** `O(n)` – the fast/slow scan runs `n/2` steps, the reversal runs `n/2` steps, and the final merge traverses the remaining nodes, each linear in the number of nodes.  
- **Space:** `O(1)` – only a constant number of pointers (`slow`, `fast`, `curr`, `prev`, `originalList`, `next1`, `next2`) are used; no auxiliary data structures are allocated.

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
        // with one variable 
        // while (prev != null) {
        //     ListNode temp = originalList.next;
        //     originalList.next = prev;
        //     originalList = prev;
        //     prev = prev.next;
        //     originalList.next = temp;
        //     originalList = temp;
        // }
        // with two
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

**Runtime** 2 ms (beats 86.7%) · **Memory** 49.2 MB (beats 71.5%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
