# 21. Merge Two Sorted Lists

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/merge-two-sorted-lists/)

`Linked List` · `Recursion`

## Intuition  
Both input lists are already sorted. The merged list can be built by repeatedly taking the smallest current head from the two lists and appending it to the result. Because the lists are singly linked, we can splice nodes directly without creating new ones, preserving the original structure.

## Approach  
1. Handle trivial cases: if one list is empty, return the other.  
2. Determine the first node of the merged list by comparing the two heads; set `Head` to that node and advance the corresponding input pointer.  
3. Use a pointer `p` to track the last node in the merged list.  
4. While both lists have remaining nodes, compare their current values. Attach the smaller node to `p->next`, advance that list, and move `p` forward.  
5. Once one list is exhausted, link the remainder of the other list to `p->next`.  
6. Return `Head`, which now points to the fully merged, sorted list.

## Complexity  
- **Time:** O(n + m) – each node is visited once while merging.  
- **Space:** O(1) – only a few pointers are used; no additional data structures are allocated.

## Solution (cpp)

```cpp
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if (!list1 || !list2) return list1 ? list1 : list2;
        ListNode *Head = NULL;
        
        if (list1->val <= list2->val) {
            Head = list1;
            list1 = list1->next;
        } else {
            Head = list2;
            list2 = list2->next;
        }
        ListNode *p = Head;

        while(list1 && list2){
            if(list1->val <= list2->val){
                p->next = list1;
                list1 = list1->next;
            }
            else{
                p->next = list2;
                list2 = list2->next;
            }
            p = p->next;
        }
        (list1) ? p->next = list1 : p->next = list2;

        return Head;
    }
};
```

---

**Runtime** 4 ms · **Memory** 19.8 MB

<sub>Synced by AILeetHub on 2024-09-17.</sub>
