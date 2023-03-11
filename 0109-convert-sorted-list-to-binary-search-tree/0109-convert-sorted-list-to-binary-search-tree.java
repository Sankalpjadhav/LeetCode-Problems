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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while(current != null){
            list.add(current.val);
            current = current.next;
        }
        int n = list.size();
        return buildBST(0, n-1, list);
    }
    
    private TreeNode buildBST(int low, int high, List<Integer> list){
        if(low > high){
            return null;
        }
        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBST(low, mid-1, list);
        root.right = buildBST(mid+1, high, list);
        
        return root;
    }
}