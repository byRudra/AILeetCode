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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode Prev = head;
        ListNode Curr = head.next;

        while(Curr != null){
            if (Prev.val == Curr.val){
                Prev.next = Curr.next;
            }
            else{
            Prev = Curr;
        }
            Curr = Curr.next;
        }
        return head;
    }
}