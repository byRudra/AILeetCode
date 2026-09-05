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
            ListNode next1 = originalList.next;
            ListNode next2 = prev.next;

            originalList.next = prev;
            prev.next = next1;

            originalList = next1;
            prev = next2;
        }
    }
}