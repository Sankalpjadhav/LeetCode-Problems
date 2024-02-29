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
    public boolean isEvenOddTree(TreeNode root) {
        if(root.val % 2 == 0){
            return false;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){ 
            int size = queue.size();

            level++; 
            int lastOdd = 0, lastEven = (int)1e7; // bcoz in constraint they have mentioned Node.val <= 10^6, so keeping lastEven greater than that.
            while(size-- > 0){
                TreeNode node = queue.poll();

                if(node.left != null){
                    if(level % 2 == 0){ 
                        //even
                        if(node.left.val % 2 == 0){
                            return false;
                        }
                        else{
                            if(lastOdd >= node.left.val){
                                return false;
                            }
                            lastOdd = node.left.val;
                        }
                    }
                    else{ 
                        // odd
                        if(node.left.val % 2 == 1){ 
                            return false;
                        }
                        else{
                            if(lastEven <= node.left.val){
                                return false;
                            }
                            lastEven = node.left.val;
                        }
                    }
                    queue.add(node.left);
                }

                if(node.right != null){ 
                    if(level % 2 == 0){ 
                        //even
                        if(node.right.val % 2 == 0){
                            return false;
                        }
                        else{
                            if(lastOdd >= node.right.val){
                                return false;
                            }
                            lastOdd = node.right.val;
                        }
                    }
                    else{ 
                        // odd
                        if(node.right.val % 2 == 1){
                            return false;
                        }
                        else{
                            if(lastEven <= node.right.val){
                                return false;
                            }
                            lastEven = node.right.val;
                        }
                    }
                    queue.add(node.right);
                }
            }
        }
        return true;
    }
}