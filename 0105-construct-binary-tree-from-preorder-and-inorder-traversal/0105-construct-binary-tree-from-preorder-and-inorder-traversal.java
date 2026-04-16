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
    int preIdx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length-1);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int left, int right){
        if(left > right) return null;
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int idx = map.get(rootVal);
        
        root.left = helper(preorder, inorder, left, idx-1);
        root.right = helper(preorder, inorder, idx+1, right);
        return root;
    }
}