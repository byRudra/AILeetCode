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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode beforeA = list1;
        ListNode afterB = list1;

        for (int i = 0; i < a - 1; i++) {
            beforeA = beforeA.next;
        }

        for (int i = 0; i <= b; i++) {
            afterB = afterB.next;
        }

        beforeA.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = afterB;

        return list1;
    }
}