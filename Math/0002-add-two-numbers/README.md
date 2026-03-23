# 2. Add Two Numbers

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/add-two-numbers/)

`Linked List` · `Math` · `Recursion`

## Intuition  
The two input lists store digits in reverse order, so the first node is the least significant digit. Adding the numbers is therefore a simple digit‑by‑digit carry propagation, just like elementary addition. A dummy head node lets us build the result list without special‑case handling for the first node.

## Approach  
Create a dummy `ListNode` and a pointer `current` to it. Maintain a `carry` initialized to 0. While any of `l1`, `l2`, or `carry` is non‑zero, read the current digit from each list (treat missing nodes as 0). Compute `sum = val1 + val2 + carry`. The new digit is `sum % 10`; update `carry` to `sum // 10`. Append a new node with the digit to the result list and advance `current`. Move `l1` and `l2` forward if they exist. When the loop ends, `dummy.next` points to the head of the summed list, which is returned.

## Complexity  
- **Time:** O(max(m, n)) – each node of the longer list is processed once.  
- **Space:** O(max(m, n)) – the output list stores one node per digit of the sum.

## Solution (python3)

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:

        dummy = ListNode(0)
        current = dummy
        carry = 0

        while l1 or l2 or carry:
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0

            sum = val1 + val2 + carry
            carry = sum // 10
            current.next = ListNode(sum % 10)
            current = current.next

            if l1 : l1 = l1.next
            if l2 : l2 = l2.next

        return dummy.next 

        
```

---

**Runtime** 0 ms · **Memory** 19.3 MB

<sub>Synced by AILeetHub on 2026-03-23.</sub>
