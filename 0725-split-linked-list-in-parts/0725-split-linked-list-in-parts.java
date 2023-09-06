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
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        
        ListNode ptr = root;
        
        while(ptr != null){
            len++;
            ptr = ptr.next;
        }
        
        ListNode [] list = new ListNode[k];
        ListNode head = root;
        
        if(len <= k){
            for(int i=0;i<len;i++){
                ListNode next = head.next;
                head.next = null;
                list[i] = head;
                head = next;
            }
            
            return list;
        }
        
        int remainder = len % k;
        int groupSize = len / k;
        ListNode pointer = root;
        
        for(int i=0;i<k;i++){
            list[i] = pointer;
            for(int j=0;j<groupSize-1;j++){
                pointer = pointer.next;
            }
            if(remainder > 0){
                pointer = pointer.next;
                remainder--;
            }
            
            ListNode next = pointer.next;
            pointer.next = null;
            pointer = next;
        }
        
        return list;
    }
}


/*
My previous written code: 38/43 cases passed

class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        
        ListNode ptr = root;
        
        while(ptr != null){
            len++;
            ptr = ptr.next;
        }
        
        ListNode [] list = new ListNode[k];
        ListNode head = root;
        
        if(len <= k){
            for(int i=0;i<len;i++){
                ListNode next = head.next;
                head.next = null;
                list[i] = head;
                head = next;
            }
            
            return list;
        }
        
        int remainder = len % k;
        int groupSize = len / k;
        ListNode pointer = root;
        
        for(int i=0;i<k;i++){
            list[i] = pointer;
            for(int j=0;j<groupSize-1;j++){
                pointer = pointer.next;
            }
            if(i == 0){
                for(int l=0;l<remainder;l++){
                    pointer = pointer.next;
                }
            }
            
            ListNode next = pointer.next;
            pointer.next = null;
            pointer = next;
        }
        
        return list;
    }
}
*/