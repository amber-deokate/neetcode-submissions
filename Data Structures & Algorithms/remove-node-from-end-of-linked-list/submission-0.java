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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode f = head, s = head, prev = dummy;

        while (n > 0) {
            f = f.next;
            n--;
        }
        while (f != null) {
            f = f.next;
            s = s.next;
            prev = prev.next;
        }
        prev.next = s.next;
        return dummy.next;

    }
}
