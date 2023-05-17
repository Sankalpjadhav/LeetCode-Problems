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
        int length = 0;
        ListNode ptr = head;
        
        while(ptr!=null){
            length++;
            ptr = ptr.next;
        }
        
        ListNode nextPtr = head;
        
        for(int i=1;i<=length/2-1;i++){
            nextPtr = nextPtr.next;
        }
        
        nextPtr.next = reverseLL(nextPtr.next);
        
        nextPtr = nextPtr.next;
        ptr = head;
        
        int maxTwinSum = 0;
        while(nextPtr!=null){
            maxTwinSum = Math.max(maxTwinSum, ptr.val + nextPtr.val);
            nextPtr = nextPtr.next;
            ptr = ptr.next;
        }
        
        return maxTwinSum;
    }
    
    private ListNode reverseLL(ListNode head){
        ListNode currentPtr = head;
        ListNode prev = null;
        
        while(currentPtr!=null){
            ListNode next = currentPtr.next;
            currentPtr.next = prev;
            prev = currentPtr;
            currentPtr = next;
        }
        
        return prev;
    }
}