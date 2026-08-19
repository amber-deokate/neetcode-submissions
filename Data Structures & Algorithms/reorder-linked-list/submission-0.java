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
        ListNode nxt = head.next;
        head.next = null;
        ListNode rev = reverse(nxt);
        nxt.next = head;
        return rev;
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

        ListNode s = head, f = head, prev = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            prev = s;
            s = s.next;
        }

        prev.next = null;
        ListNode head2 = reverse(s);
        merge(head, head2);


    }
}
