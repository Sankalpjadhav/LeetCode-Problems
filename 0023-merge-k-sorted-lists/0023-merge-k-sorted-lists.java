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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(ListNode head: lists){
            while(head!=null){
                minHeap.add(head.val);
                head = head.next;
            }
        }
        
        ListNode dummyNode = new ListNode(-1);
        ListNode ptr = dummyNode;
        while(!minHeap.isEmpty()){
            ptr.next = new ListNode(minHeap.poll());
            ptr = ptr.next;
        }
        
        return dummyNode.next;
    }
}