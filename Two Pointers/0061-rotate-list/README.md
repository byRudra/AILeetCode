# 61. Rotate List

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/rotate-list/)

`Linked List` · `Two Pointers`

## Intuition
Rotating a list right by *k* positions is equivalent to moving the last *k* nodes to the front while preserving their order. Instead of physically shifting nodes, we can rewire pointers once we know the list’s length and the new break point.

## Approach
1. **Edge cases** – If the list is empty, has one node, or *k* is zero, return the head unchanged.  
2. **Determine length and tail** – Traverse the list once to count nodes (`size`) and keep a reference to the last node (`tail`).  
3. **Normalize *k*** – Compute `k % size`. If the result is zero, the list remains unchanged.  
4. **Find new tail** – The new tail is the node at position `size - k` from the start. Walk from the head that many steps.  
5. **Rewire pointers** –  
   - Set `newHead` to `newTail.next`.  
   - Break the list by setting `newTail.next = null`.  
   - Connect the old tail to the original head (`tail.next = head`).  
6. **Return** the `newHead`.

This single pass to find length, a second pass to locate the new tail, and constant‑time pointer updates achieve the rotation in one traversal of the list.

## Complexity
- **Time:** O(n) – one full traversal to compute length and a second to locate the new tail.  
- **Space:** O(1) – only a few pointers are used regardless of list size.

## Solution (java)

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){return head;}

        // calculating size and finding the tail of the linked list
        ListNode tail = head;
        int size = 1;
        while(tail.next != null){
            tail = tail.next;
            size++;
        }

        // Adjusting the value of K
        k = k % size;
        if(k == 0) return head;

        // Calculating the new tail
        ListNode newTail = head;
        for(int i = 1; i < size - k; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        newTail.next = null;
        tail.next = head;

        return newHead;
        
    }
}
```

---

**Runtime** 0 ms · **Memory** 44.3 MB

<sub>Synced by AILeetHub on 2025-11-09.</sub>
