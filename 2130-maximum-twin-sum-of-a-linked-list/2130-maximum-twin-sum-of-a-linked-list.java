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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverseLinkedList(slow.next);
        slow = slow.next;
        ListNode ptr = head;
        int maxTwinSum = 0;
        while(slow != null){
            maxTwinSum = Math.max(maxTwinSum, ptr.val + slow.val);
            ptr = ptr.next;
            slow = slow.next;
        }
        
        return maxTwinSum;
    }
    
    private ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        
        while(head!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
}

/*
            f
      s
1 2 3 4 5 6 7 8
*/