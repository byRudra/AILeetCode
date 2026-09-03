# 23. Merge k Sorted Lists

![Hard](https://img.shields.io/badge/Difficulty-Hard-ff375f?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/merge-k-sorted-lists/)

`Linked List` · `Divide and Conquer` · `Heap (Priority Queue)` · `Merge Sort` · `Tournament Sort`

## Intuition  
When several sorted linked lists are merged, the next element to output is always the smallest head among the lists that still have nodes. A priority queue (min‑heap) keeps these heads sorted, allowing constant‑time access to the smallest element and logarithmic updates when a head is removed or replaced by its successor.

## Approach  
1. **Initialize** a priority queue that orders `ListNode` objects by their `val`.  
2. **Seed** the queue with the first node of each non‑empty input list.  
3. Create a dummy head for the resulting list and maintain a `tail` pointer.  
4. While the queue is not empty:  
   - Poll the smallest node (`next`).  
   - Append `next` to the result (`tail.next = next`) and advance `tail`.  
   - If `next.next` exists, offer it to the queue so the next candidate from that list becomes available.  
5. Return `dummy.next`, the head of the merged list.

This process guarantees that at each step the smallest remaining element is chosen, producing a fully sorted list.

## Complexity  
- **Time:** O(N log k) – each of the N total nodes is inserted and removed from the heap once, costing O(log k) per operation.  
- **Space:** O(k) – the heap holds at most one node from each of the k lists at any time.

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for(ListNode list: lists){
            if(list != null){
                pq.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!pq.isEmpty()){
            ListNode next = pq.poll();
            tail.next = next;
            tail = next;
            if(next.next != null){
                pq.offer(next.next);
            }
        }
        return dummy.next;
    }
}
```

---

**Runtime** 4 ms · **Memory** 46.5 MB

<sub>Synced by AILeetHub on 2026-09-03.</sub>
