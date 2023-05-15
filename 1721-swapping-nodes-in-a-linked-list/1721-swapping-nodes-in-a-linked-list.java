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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode handler = head;
        int len = 0;
        while(handler!=null){
            len++;
            handler = handler.next;
        }
        ListNode first = head;
        for(int i=1;i<k;i++){
            first = first.next;
        }
        ListNode second = head;
        for(int j=1;j<len-k+1;j++){
            second = second.next;
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
    }
}