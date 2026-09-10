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
    int ans = 0;
    private int find(TreeNode root){
        if(root == null) return 0;
        int[] res = getSumCount(root);
        int sum = res[0];
        int count = res[1];
        int avg = sum / count;
        
        if(root.val == avg) {
            ans++;
        }
        find(root.left);
        find(root.right);
        return ans;
    }
    private int[] getSumCount(TreeNode root){
        if(root == null) return new int[]{0, 0};
        int[] left = getSumCount(root.left);
        int[] right = getSumCount(root.right);
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        return new int[]{sum, count}; 
    }
    public int averageOfSubtree(TreeNode root) {
        return find(root);
    }
}