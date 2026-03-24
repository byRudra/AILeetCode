# 206. Reverse Linked List

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/reverse-linked-list/)

`Linked List` · `Recursion`

## Intuition
Reversing a singly linked list means that each node’s `next` pointer should point to its predecessor instead of its successor. By walking through the list once and reassigning pointers, we can transform the list in place without allocating new nodes.

## Approach
The algorithm starts by handling the empty list case. It then initializes two pointers: `prev` pointing to the first node and `current` pointing to the second node. The first node’s `next` is set to `None` to mark the new tail. In a loop, the algorithm temporarily stores `current.next`, redirects `current.next` to `prev`, then advances both pointers: `prev` becomes `current` and `current` becomes the stored next node. This process continues until `current` becomes `None`, at which point `prev` points to the new head of the reversed list. The function returns `prev`.

## Complexity
- **Time:** O(n) – each node is visited exactly once.
- **Space:** O(1) – only a constant number of pointers are used, regardless of list size.

## Solution (python3)

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None:
            return None
        prev = head
        current = head.next
        prev.next = None
        while(current):
            temp = current.next
            current.next = prev
            prev = current
            current = temp
        return prev
```

---

**Runtime** 0 ms · **Memory** 20.4 MB

<sub>Synced by AILeetHub on 2026-03-24.</sub>
