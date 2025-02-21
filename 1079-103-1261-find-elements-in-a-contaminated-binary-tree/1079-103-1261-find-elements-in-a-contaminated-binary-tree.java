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
class FindElements {   
    Set<Integer> container;

    public FindElements(TreeNode root) {
        container = new HashSet<Integer>();
        root.val = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        container.add(root.val);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();

                if(node.left != null){
                    node.left.val = (2 * node.val) + 1;
                    queue.add(node.left);
                    container.add(node.left.val);
                }

                if(node.right != null){
                    node.right.val = (2 * node.val) + 2;
                    queue.add(node.right);
                    container.add(node.right.val);
                }
            }
        }
    }
    
    public boolean find(int target) {
        return container.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */