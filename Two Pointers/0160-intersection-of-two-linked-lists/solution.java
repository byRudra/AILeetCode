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