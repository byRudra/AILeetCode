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