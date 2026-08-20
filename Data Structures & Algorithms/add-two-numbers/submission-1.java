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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
        }
        return dummy.next;
        
    }

    ListNode f(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return carry == 1 ? new ListNode(1) : null;
        }
            
        if (l1 == null) {
            int sum = carry + l2.val;
            carry = sum / 10;
            int val = sum % 10;
            l2.val = val;
            l2.next = f(l1, l2.next, carry);
            return l2;
        }
        if (l2 == null) {
            int sum = carry + l1.val;
            carry = sum / 10;
            int val = sum % 10;
            l1.val = val;
            l1.next = f(l1.next, l2, carry);
            return l1;
        }
        int sum = carry + l1.val + l2.val;
        carry = sum / 10;
        int val = sum % 10;
        l1.val = val;
        l1.next = f(l1.next, l2.next, carry);
        return l1;

        
        
    }
}
