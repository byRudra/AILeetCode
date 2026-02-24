class Solution {
    public ListNode mergeNodes(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int sum = 0;
        head = head.next; // skip first zero

        while (head != null) {

            if (head.val == 0) {
                // end of segment
                tail.next = new ListNode(sum);
                tail = tail.next;
                sum = 0;
            } else {
                sum += head.val;
            }

            head = head.next;
        }

        return dummy.next;
    }
}