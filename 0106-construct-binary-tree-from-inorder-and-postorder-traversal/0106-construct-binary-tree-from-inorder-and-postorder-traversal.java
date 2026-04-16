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
    int postIdx ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length-1;
        return helper(inorder, postorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] inorder, int[] postorder, int left, int right){
        if(left > right){
            return null;
        }
        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);
        int i=left;
        for(;i<=right;i++){
            if(inorder[i] == rootVal){
                break;
            }
        }
        root.right = helper(inorder, postorder, i+1, right);
        root.left = helper(inorder, postorder, left, i-1);
        
        return root;
    }
}