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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
        {
            return root;
        }
        TreeNode newLeft= root.right;
        TreeNode newRight= root.left;
        root.left=newLeft;
        root.right= newRight;
        root.left=invertTree(root.left);
        root.right=invertTree(root.right);
        return root;
    }
}