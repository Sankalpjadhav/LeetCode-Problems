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
    public ListNode deleteMiddle(ListNode head) {
        int length = 0;
        length = findLength(head);
        System.out.println(length);
        if(length == 1){
            return null;
        }
        
        ListNode ptr = head;
        
        for(int i=0;i<length/2-1;i++){
            ptr = ptr.next;
        }
        
        ptr.next = ptr.next.next;
        
        return head;
    }
    
    private int findLength(ListNode head){
        ListNode ptr = head;
        int length = 0;
        
        while(ptr!=null){
            length++;
            ptr = ptr.next;
        }
        
        return length;
    }
}