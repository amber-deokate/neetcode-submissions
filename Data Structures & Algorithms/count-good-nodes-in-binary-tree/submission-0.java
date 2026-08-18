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
    int count = 0;
    public int goodNodes(TreeNode root) {
        count = 0;
        f(root, Integer.MIN_VALUE);
        return count;
        
        
    }
    void f(TreeNode root, int currMax) {
        if (root == null) {
            return;
        }
        if (root.val >= currMax) {
            count++;
        }
        f(root.left, Math.max(currMax, root.val));
        f(root.right, Math.max(currMax, root.val));
    }
}
