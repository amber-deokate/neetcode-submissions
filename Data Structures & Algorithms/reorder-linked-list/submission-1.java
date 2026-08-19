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

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode n1 = head1.next;
        ListNode n2 = head2.next;
        head1.next = head2;
        head2.next = merge(n1, n2);
        return head1;
    }



    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode s = head, f = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        ListNode sNext = s.next;
        s.next = null;
        ListNode head2 = reverse(sNext);
        ListNode head1 = head;
        while (head2 != null) {
            ListNode n1 = head1.next;
            ListNode n2 = head2.next;
            head1.next = head2;
            head2.next = n1;
            head1 = n1;
            head2 = n2;


        }




    }
}
