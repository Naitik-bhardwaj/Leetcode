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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solution(root, targetSum);
    }
    public boolean solution(TreeNode root, int targetSum){
        if(root == null) return false;
        if(root.left == null && root.right == null) return targetSum == root.val;
        int r = targetSum - root.val;

        if(solution(root.left, r)){
            return true;
        }
        if(solution(root.right,r)){
            return true;
        }
        return false;
    }
}