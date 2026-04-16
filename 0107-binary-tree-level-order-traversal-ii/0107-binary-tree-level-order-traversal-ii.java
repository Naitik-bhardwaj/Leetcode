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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return helper(root);
    }
    public List<List<Integer>> helper(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode newNode = q.remove();
                level.add(newNode.val);

                if(newNode.left != null) q.add(newNode.left);
                if(newNode.right != null) q.add(newNode.right);
            }
            ans.add(level);
        }
        Collections.reverse(ans);
        return ans;
    }
}