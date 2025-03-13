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
    public ListNode deleteDuplicates(ListNode head) {
        // My brute force approach would be to maintain TreeMap <Node value, Count> 
        // Initially go through the list and count number of values
        // Create a new list with values count 1

        // Optimal approach

        if(head == null || head.next == null){
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode ptr = dummyNode;

        while(head != null){
            int count = 1;
            while(head.next!=null && head.val == head.next.val){
                count++;
                head = head.next;
            }

            if(count == 1){
                ptr.next = head;
                ptr = ptr.next;
            }
            head = head.next;
        }

        ptr.next = null;

        return dummyNode.next;
    }
}