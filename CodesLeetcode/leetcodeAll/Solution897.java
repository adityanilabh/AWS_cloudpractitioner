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
/* 
class Solution {
    TreeNode newNode= null;
    TreeNode currNode=null;
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        TreeNode currsNode= new TreeNode(root.val);
        if(newNode==null)
        {
           newNode=currsNode;
           currNode=currsNode;
        }
        else
        {
            currNode.right=currsNode;
            currNode=currNode.right;
        }
        inorder(root.right);

    }
    public TreeNode increasingBST(TreeNode root) { 
        inorder(root);
        return newNode;
    }
}
*/