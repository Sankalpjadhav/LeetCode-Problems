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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        pq.add((long)root.val);
        
        int levels = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            long sum = 0;
            levels++;
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    sum += node.left.val;
                    queue.add(node.left);
                }
                if(node.right != null){
                    sum += node.right.val;
                    queue.add(node.right);
                }
            }
            pq.add(sum);
        }
        
        if(levels < k){
            return -1;
        }
        
        while(k-- > 1){
            pq.poll();
        }
        
        return pq.peek();
    }
}