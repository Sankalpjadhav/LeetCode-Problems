/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<TreeNode*> generateTrees(int n) {
        return helper(1, n);
    }
    
private:
    vector<TreeNode*> helper(int left, int right){
        vector<TreeNode*> result;
        if(left > right){
            result.push_back(nullptr);
            return result;
        }
        
        for(int node=left;node<=right;node++){
            vector<TreeNode*> leftNodes = helper(left, node-1);
            vector<TreeNode*> rightNodes = helper(node+1, right);
            
            for(TreeNode *l:leftNodes){
                for(TreeNode *r:rightNodes){
                    TreeNode *root = new TreeNode(node);
                    root->left = l;
                    root->right = r;
                    result.push_back(root);
                }
            }
        }
        
        return result;
    }
};
