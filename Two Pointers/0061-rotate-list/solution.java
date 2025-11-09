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