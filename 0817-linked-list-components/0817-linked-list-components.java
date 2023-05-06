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
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        
        for(int num: G){
            set.add(num);
        }
        
        int totalComponents = 0;
        boolean flag = false;
        
        while(head != null){
            int val = head.val;
            
            if(set.contains(val) && flag == false){
                totalComponents++;
                flag = true;
            }
            
            if(!set.contains(val) && flag == true){
                flag = false;
            }
            
            head = head.next;
        }
        
        return totalComponents;
    }
}