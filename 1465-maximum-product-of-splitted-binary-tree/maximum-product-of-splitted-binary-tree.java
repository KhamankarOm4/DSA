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
    
        long total = 0 ;
        long best = 0;
        int MOD = 1_000_000_007;
        long sum(TreeNode node){
            if(node == null) return 0;
            return node.val + sum(node.left)+sum(node.right);
        }

        long bfs(TreeNode node){
            if(node == null) return 0;
            long s = node.val + bfs(node.left) + bfs(node.right);
            best = Math.max(best,s*(total-s));
            return s;
        }

        public int maxProduct(TreeNode root){
            total = sum(root);
            bfs(root);
            return (int)(best%MOD);
        }
   
}