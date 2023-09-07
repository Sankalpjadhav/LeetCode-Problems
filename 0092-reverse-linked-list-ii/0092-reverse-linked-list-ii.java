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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current = head;
        ListNode prev = null;
        while(head == null){
            return head;
        }
        while(m>1){
            prev = current;
            current = current.next;
            m--;
            n--;
        }
        ListNode con=prev, tail=current, next=null;
        while(n>0){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            n--;
        }
        
        if(con!=null){
            con.next=prev;
        }
        else{
            head=prev;
        }
        
        tail.next=current;
        return head;
        
        
        
    }
}