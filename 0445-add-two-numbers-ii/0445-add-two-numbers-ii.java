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
        ListNode head1 = reverseList(l1);
        ListNode head2 = reverseList(l2);
        
        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode resultPtr = result;
        int addResult = 0;
        while(head1 != null && head2 != null){
            addResult = head1.val + head2.val + carry;
            resultPtr.next = new ListNode(addResult % 10);
            resultPtr = resultPtr.next;
            carry = addResult / 10;
            head1 = head1.next;
            head2 = head2.next;
        }
        
        while(head1 != null){
            addResult = head1.val + carry;
            resultPtr.next = new ListNode(addResult % 10);
            carry = addResult / 10;
            resultPtr = resultPtr.next;
            head1 = head1.next;
        }
        
        while(head2 != null){
            addResult = head2.val + carry;
            resultPtr.next = new ListNode(addResult % 10);
            carry = addResult / 10;
            resultPtr = resultPtr.next;
            head2 = head2.next;
        }
        
        if(carry == 1){
            resultPtr.next = new ListNode(carry);
            resultPtr = resultPtr.next;
        }
        
        return reverseList(result.next);
    }
    
    private ListNode reverseList(ListNode root){
        ListNode prev = null;
        ListNode next = null;
        
        while(root != null){
            next = root.next;
            root.next = prev;
            prev = root;
            root = next;
        }
        
        return prev;
    }
}