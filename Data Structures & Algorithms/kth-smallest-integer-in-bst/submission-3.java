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
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        f(root, k);
        return ans;
        
    }

    void f(TreeNode root, int k) {
        if (root == null || ans != -1) {
            return;
        }
        f(root.left, k);
        if (ans != -1) {
            return;
        }
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        
        f(root.right, k);

    }
}
